use std::{cmp::max, collections::BinaryHeap};

impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        let mut heap = BinaryHeap::new();
        let mut ret = -1;
        let n = values.len() as i32;
        for j in 0..n {
            if let Some((_score, i)) = heap.peek() {
                ret = max(ret, values[*i as usize] + values[j as usize] + i - j);
            }
            heap.push((values[j as usize] + j, j));
        }
        ret
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::max_score_sightseeing_pair(vec![8, 1, 5, 2, 6]),
        11
    );
    assert_eq!(Solution::max_score_sightseeing_pair(vec![1, 2]), 2);
}
