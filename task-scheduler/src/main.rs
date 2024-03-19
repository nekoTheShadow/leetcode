use std::collections::HashMap;

impl Solution {
    pub fn least_interval(tasks: Vec<char>, n: i32) -> i32 {
        let mut counter = HashMap::new();
        for task in &tasks {
            *counter.entry(task).or_insert(0) += 1;
        }

        let &max_v = counter.values().max().unwrap();
        let mut ret = (max_v - 1) * (n + 1);
        for (_k, v) in counter {
            if v == max_v {
                ret += 1;
            }
        }
        ret.max(tasks.len() as i32)
    }
}

struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::least_interval(vec!['A', 'A', 'A', 'B', 'B', 'B'], 2)
    );
    println!(
        "{}",
        Solution::least_interval(vec!['A', 'C', 'A', 'B', 'D', 'B'], 2)
    );
    println!(
        "{}",
        Solution::least_interval(vec!['A', 'A', 'A', 'B', 'B', 'B'], 3)
    );
}
