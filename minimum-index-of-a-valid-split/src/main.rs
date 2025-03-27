use std::collections::HashMap;

impl Solution {
    pub fn minimum_index(nums: Vec<i32>) -> i32 {
        let mut d1 = HashMap::new();
        let mut d2 = HashMap::new();
        for &num in &nums {
            *d2.entry(num).or_insert(0) += 1;
        }

        for (i, num) in nums.iter().enumerate() {
            *d1.entry(*num).or_insert(0) += 1;
            *d2.get_mut(num).unwrap() -= 1;
            if d1[num] * 2 > i + 1 && d2[num] * 2 > nums.len() - i - 1 {
                return i as i32;
            }
        }

        -1
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::minimum_index(vec![1, 2, 2, 2]), 2);
    assert_eq!(
        Solution::minimum_index(vec![2, 1, 3, 1, 1, 1, 7, 1, 2, 1]),
        4
    );
    assert_eq!(Solution::minimum_index(vec![3, 3, 3, 3, 7, 2, 2]), -1);
}
