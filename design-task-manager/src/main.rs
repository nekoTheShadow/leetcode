use std::collections::{BTreeSet, HashMap};

struct TaskManager {
    // key: task_id, value: user_id
    user_ids: HashMap<i32, i32>,
    // key: task_id, value: priority
    priorities: HashMap<i32, i32>,
    // (priority, taskid)
    tuples: BTreeSet<(i32, i32)>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl TaskManager {
    fn new(tasks: Vec<Vec<i32>>) -> Self {
        let mut s = Self {
            user_ids: HashMap::new(),
            priorities: HashMap::new(),
            tuples: BTreeSet::new(),
        };
        for task in tasks {
            let user_id = task[0];
            let task_id = task[1];
            let priority = task[2];
            s.add(user_id, task_id, priority);
        }
        s
    }

    fn add(&mut self, user_id: i32, task_id: i32, priority: i32) {
        self.user_ids.insert(task_id, user_id);
        self.priorities.insert(task_id, priority);
        self.tuples.insert((priority, task_id));
    }

    fn edit(&mut self, task_id: i32, new_priority: i32) {
        let old_priority = self.priorities[&task_id];
        self.priorities.insert(task_id, new_priority);
        self.tuples.remove(&(old_priority, task_id));
        self.tuples.insert((new_priority, task_id));
    }

    fn rmv(&mut self, task_id: i32) {
        let priority = self.priorities[&task_id];
        self.user_ids.remove(&task_id);
        self.priorities.remove(&task_id);
        self.tuples.remove(&(priority, task_id));
    }

    fn exec_top(&mut self) -> i32 {
        if let Some(&(_priority, task_id)) = self.tuples.last() {
            let user_id = self.user_ids[&task_id];
            self.rmv(task_id);
            user_id
        } else {
            -1
        }
    }
}

fn main() {
    example1();
    ng1();
}

fn example1() {
    // Input:
    // ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
    // [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]

    let mut tm = TaskManager::new(vec![vec![1, 101, 10], vec![2, 102, 20], vec![3, 103, 15]]);

    // "add", [4, 104, 5]
    tm.add(4, 104, 5);

    // "edit", [102, 8]  → task 102 priority = 8
    tm.edit(102, 8);

    // "execTop", [] → 最も優先度が高いのは task 103 (priority=15, userId=3)
    let r1 = tm.exec_top();
    assert_eq!(r1, 3);

    // "rmv", [101] → task 101 を削除
    tm.rmv(101);

    // "add", [5, 105, 15]
    tm.add(5, 105, 15);

    // "execTop", [] → 最も優先度が高いのは task 105 (priority=15, userId=5)
    let r2 = tm.exec_top();
    assert_eq!(r2, 5);
}

fn ng1() {
    let mut tm = TaskManager::new(vec![vec![10, 26, 25]]);
    tm.rmv(26);
    assert_eq!(tm.exec_top(), -1);
}
