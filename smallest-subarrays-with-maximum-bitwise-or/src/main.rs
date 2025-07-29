use std::collections::HashMap;

impl Solution {
    pub fn smallest_subarrays(nums: Vec<i32>) -> Vec<i32> {
        let mut ret = Vec::new();
        let mut map = HashMap::new();
        for (i, num) in nums.iter().enumerate().rev() {
            for x in 0..30 {
                if (num >> x) & 1 == 1 {
                    map.insert(x, i);
                }
            }

            if let Some(j) = map.values().max() {
                ret.push((j - i + 1) as i32);
            } else {
                ret.push(1);
            }
        }

        ret.reverse();
        ret
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::smallest_subarrays(vec![1, 0, 2, 1, 3]),
        vec![3, 3, 2, 2, 1]
    );
    assert_eq!(Solution::smallest_subarrays(vec![1, 2]), vec![2, 1]);
}
