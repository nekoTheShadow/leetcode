use std::{cmp::max, collections::BTreeMap};

impl Solution {
    pub fn maximum_triplet_value(nums: Vec<i32>) -> i64 {
        let nums = nums.iter().map(|num| *num as i64).collect::<Vec<_>>();
        let n = nums.len();

        let mut l_max = nums[0];
        let mut r = BTreeMap::new();
        for k in 2..n {
            *r.entry(nums[k]).or_insert(0) += 1;
        }

        let mut ret = 0;
        for j in 1..n - 1 {
            let (&r_max, _) = r.last_key_value().unwrap();
            ret = max(ret, (l_max - nums[j]) * r_max);

            let next = nums[j + 1];
            if r[&next] == 1 {
                r.remove(&next);
            } else {
                *r.get_mut(&next).unwrap() -= 1;
            }
            l_max = max(l_max, nums[j]);
        }
        ret
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_triplet_value(vec![12, 6, 1, 2, 7]), 77);
    assert_eq!(Solution::maximum_triplet_value(vec![1, 10, 3, 4, 19]), 133);
    assert_eq!(Solution::maximum_triplet_value(vec![1, 2, 3]), 0);
}
