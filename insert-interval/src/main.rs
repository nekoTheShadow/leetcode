use std::collections::VecDeque;

impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        let mut intervals = intervals;
        match intervals.binary_search(&new_interval) {
            Ok(index) => intervals.insert(index, new_interval),
            Err(index) => intervals.insert(index, new_interval),
        };

        let mut stack: VecDeque<Vec<i32>> = VecDeque::new();
        for interval in intervals {
            if let Some(last_interval) = stack.back_mut() {
                if last_interval[1] + 1 <= interval[0] {
                    stack.push_back(interval);
                } else {
                    last_interval[1] = last_interval[1].max(interval[1]);
                }
            } else {
                stack.push_back(interval);
            }
        }

        stack.into_iter().collect::<Vec<_>>()
    }
}
struct Solution {}

fn main() {
    println!(
        "{:?}",
        Solution::insert(
            [[1, 3], [6, 9]].iter().map(|v| v.to_vec()).collect(),
            vec![2, 5]
        )
    );
    println!(
        "{:?}",
        Solution::insert(
            [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
                .iter()
                .map(|v| v.to_vec())
                .collect(),
            vec![4, 8]
        )
    );
}
