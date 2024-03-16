use std::collections::HashMap;

impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut a = vec![0; n + 1];
        let mut b = vec![0; n + 1];
        for i in 0..n {
            if nums[i] == 1 {
                a[i + 1] = a[i] + 1;
                b[i + 1] = b[i];
            } else {
                a[i + 1] = a[i];
                b[i + 1] = b[i] + 1;
            }
        }

        let mut h = HashMap::new();
        let mut max_len = 0;
        for y in 0..=n {
            let k = a[y] - b[y];
            if let Some(x) = h.get(&k) {
                max_len = max_len.max(y - x);
            } else {
                h.insert(k, y);
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
