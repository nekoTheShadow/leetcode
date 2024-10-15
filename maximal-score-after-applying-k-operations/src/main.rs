use std::collections::BinaryHeap;

impl Solution {
    pub fn max_kelements(nums: Vec<i32>, k: i32) -> i64 {
        let mut pq = nums
            .iter()
            .map(|num| *num as i64)
            .collect::<BinaryHeap<_>>();
        let mut total = 0;
        for _ in 0..k {
            let x = pq.pop().unwrap();
            total += x;

            if x % 3 == 0 {
                pq.push(x / 3);
            } else {
                pq.push(x / 3 + 1);
            }
        }
        total
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::max_kelements(vec![10, 10, 10, 10, 10], 5), 50);
    assert_eq!(Solution::max_kelements(vec![1, 10, 3, 3, 3], 3), 17);
}
