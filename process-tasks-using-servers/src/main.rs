use std::{cmp::Reverse, collections::BinaryHeap, println};

impl Solution {
    pub fn assign_tasks(servers: Vec<i32>, tasks: Vec<i32>) -> Vec<i32> {
        let mut wait = BinaryHeap::new();
        let mut run = BinaryHeap::new();

        for (index, &weight) in servers.iter().enumerate() {
            wait.push(Reverse((weight, index)));
        }

        let mut t = 0;
        let mut ans = Vec::new();
        for (i, &task) in tasks.iter().enumerate() {
            t = std::cmp::max(t, i as i32);

            while run.peek().is_some_and(|&Reverse((time,_index))| time <= t) {
                let Reverse((_time, index)) = run.pop().unwrap();
                wait.push(Reverse((servers[index], index)));
            }

            if wait.is_empty() {
                let &Reverse((time, _index)) = run.peek().unwrap();
                t = time;
                while run.peek().is_some_and(|&Reverse((time,_index))| time <= t) {
                    let Reverse((_time, index)) = run.pop().unwrap();
                    wait.push(Reverse((servers[index], index)));
                }
            }

            let Reverse((_weight, index)) = wait.pop().unwrap();
            ans.push(index as i32);
            run.push(Reverse((t + task, index)));
        }

        ans
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let servers = [3, 3, 2];
        let tasks = [1, 2, 3, 2, 1, 2];
        let output = [2, 2, 0, 2, 1, 2];
        assert_eq!(
            Solution::assign_tasks(servers.to_vec(), tasks.to_vec()),
            output.to_vec()
        )
    }

    #[test]
    fn example2() {
        let servers = [5, 1, 4, 3, 2];
        let tasks = [2, 1, 2, 4, 5, 2, 1];
        let output = [1, 4, 1, 4, 1, 3, 2];
        assert_eq!(
            Solution::assign_tasks(servers.to_vec(), tasks.to_vec()),
            output.to_vec()
        )
    }
}
