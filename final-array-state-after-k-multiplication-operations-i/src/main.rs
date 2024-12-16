use std::{cmp::Reverse, collections::BinaryHeap};

impl Solution {
    pub fn get_final_state(nums: Vec<i32>, k: i32, multiplier: i32) -> Vec<i32> {
        let mut pq = nums
            .iter()
            .enumerate()
            .map(|(i, v)| (Reverse(*v), Reverse(i)))
            .collect::<BinaryHeap<_>>();
        for _ in 0..k {
            let (Reverse(v), Reverse(i)) = pq.pop().unwrap();
            pq.push((Reverse(v * multiplier), Reverse(i)));
        }

        let mut a = vec![0_i32; nums.len()];
        while let Some((Reverse(v), Reverse(i))) = pq.pop() {
            a[i] = v;
        }
        a
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::get_final_state(vec![2, 1, 3, 5, 6], 5, 2),
        vec![8, 4, 6, 5, 6]
    );
    assert_eq!(Solution::get_final_state(vec![1, 2], 3, 4), vec![16, 8]);
}
