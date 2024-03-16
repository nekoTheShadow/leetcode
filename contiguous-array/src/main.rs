use std::collections::HashMap;

impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut d = vec![0; n + 1];
        for i in 0..n {
            d[i + 1] = d[i] + nums[i];
        }

        let mut h = HashMap::new();
        let mut max_len = 0;
        for x in 0..=n {
            let k = 2 * d[x] - (x as i32);
            if let Some(y) = h.get(&k) {
                max_len = max_len.max(x - y);
            } else {
                h.insert(k, x);
            }
        }

        max_len as i32
    }
}

struct Solution {}

fn main() {
    println!("{}", Solution::find_max_length(vec![0, 1]));
    println!("{}", Solution::find_max_length(vec![0, 1, 0]));
    println!(
        "{}",
        Solution::find_max_length(vec![0, 0, 1, 0, 0, 0, 1, 1])
    );
}
