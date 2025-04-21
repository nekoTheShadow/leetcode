use std::collections::HashMap;

impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        let mut h = HashMap::new();
        for answer in answers {
            *h.entry(answer).or_insert(0) += 1;
        }
        h.iter().map(|(&k, &v)| ceil_div(v, k + 1) * (k + 1)).sum()
    }
}

fn ceil_div(x: i32, y: i32) -> i32 {
    (x + y - 1) / y
}

struct Solution;

fn main() {
    assert_eq!(Solution::num_rabbits(vec![1, 1, 2]), 5);
    assert_eq!(Solution::num_rabbits(vec![10, 10, 10]), 11);
}
