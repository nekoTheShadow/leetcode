use std::collections::HashMap;

impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        let mut c = HashMap::new();
        for v1 in &nums {
            for v2 in &nums {
                if v1 != v2 {
                    *c.entry(v1 * v2).or_insert(0) += 1;
                }
            }
        }
        c.values().map(|v| v * (v - 2)).sum()
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::tuple_same_product(vec![2, 3, 4, 6]), 8);
    assert_eq!(Solution::tuple_same_product(vec![1, 2, 4, 5, 10]), 16);
}
