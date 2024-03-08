use std::collections::HashMap;

impl Solution {
    pub fn max_frequency_elements(nums: Vec<i32>) -> i32 {
        let mut counter = HashMap::new();
        for num in nums {
            *counter.entry(num).or_insert(0) += 1;
        }
        
        let mut max_v = -1;
        let mut total = 0;
        for (_k, v) in counter {
            if max_v == v {
                total += v;
            } else if max_v < v {
                max_v = v;
                total = v;
            }
        }
        total
    }
}

struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::max_frequency_elements(vec![1, 2, 2, 3, 1, 4])
    );
    println!("{}", Solution::max_frequency_elements(vec![1, 2, 3, 4, 5]));
}
