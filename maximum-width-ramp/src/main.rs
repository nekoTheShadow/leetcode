use std::collections::BTreeSet;

impl Solution {
    pub fn max_width_ramp(nums: Vec<i32>) -> i32 {
        let mut tuples = nums
            .iter()
            .enumerate()
            .map(|(i, num)| (*num, i))
            .collect::<Vec<_>>();
        tuples.sort();

        let mut indexes = (0..nums.len()).collect::<Vec<_>>();
        indexes.sort_unstable_by_key(|i| nums[*i]);

        let mut set = BTreeSet::new();
        let mut ret = 0;
        for (_num, j) in tuples {
            if let Some(i) = set.first() {
                if *i < j {
                    ret = std::cmp::max(ret, j - i);
                }
            }
            set.insert(j);
        }
        ret as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::max_width_ramp(vec![6, 0, 8, 2, 1, 5]), 4);
    assert_eq!(
        Solution::max_width_ramp(vec![9, 8, 1, 0, 1, 9, 4, 0, 4, 1]),
        7
    );
}
