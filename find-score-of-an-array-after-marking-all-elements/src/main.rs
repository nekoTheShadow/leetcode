use std::collections::BTreeSet;

impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        let mut treeset = nums
            .iter()
            .enumerate()
            .map(|(i, &num)| (num, i))
            .collect::<BTreeSet<_>>();
        let mut score = 0_i64;
        while let Some((num, i)) = treeset.pop_first() {
            score += num as i64;
            if i != 0 {
                treeset.remove(&(nums[i - 1], i - 1));
            }
            if i != nums.len() - 1 {
                treeset.remove(&(nums[i + 1], i + 1));
            }
        }
        score
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::find_score(vec![2, 1, 3, 4, 5, 2]), 7);
    assert_eq!(Solution::find_score(vec![2, 3, 5, 1, 3, 2]), 5);
}
