use std::{cmp::Reverse, collections::BinaryHeap};

impl Solution {
    pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
        let k = k as i128;
        let mut pq = nums
            .into_iter()
            .map(|num| Reverse(num as i128))
            .collect::<BinaryHeap<_>>();
        let mut operation = 0;
        while less_than_k(&mut pq, k) {
            let Reverse(x) = pq.pop().unwrap();
            let Reverse(y) = pq.pop().unwrap();
            pq.push(Reverse(x * 2 + y));
            operation += 1;
        }
        operation
    }
}

fn less_than_k(pq: &mut BinaryHeap<Reverse<i128>>, k: i128) -> bool {
    if let Some(Reverse(x)) = pq.peek() {
        if *x < k {
            return true;
        }
    }
    false
}

struct Solution;

fn main() {
    assert_eq!(Solution::min_operations(vec![2, 11, 10, 1, 3], 10), 2);
    assert_eq!(Solution::min_operations(vec![1, 1, 2, 4, 9], 20), 4);
    assert_eq!(
        Solution::min_operations(vec![999999999, 999999999, 999999999], 1000000000),
        2
    );
}
