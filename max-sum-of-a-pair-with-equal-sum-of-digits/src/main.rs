use std::collections::HashMap;

impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        let mut dict = HashMap::new();
        for num in nums {
            dict.entry(sum_of_digits(num))
                .or_insert(Vec::new())
                .push(num);
        }

        let mut max = -1;
        for (_key, vals) in dict.iter_mut() {
            if vals.len() < 2 {
                continue;
            }
            vals.sort();
            vals.reverse();
            max = std::cmp::max(max, vals[0] + vals[1]);
        }
        max
    }
}

fn sum_of_digits(mut x: i32) -> i32 {
    let mut total = 0;
    while x > 0 {
        total += x % 10;
        x /= 10;
    }
    total
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_sum(vec![18, 43, 36, 13, 7]), 54);
    assert_eq!(Solution::maximum_sum(vec![10, 12, 19, 14]), -1);
}
