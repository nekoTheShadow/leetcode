use std::collections::BTreeMap;

impl Solution {
    pub fn continuous_subarrays(nums: Vec<i32>) -> i64 {
        let n = nums.len();
        let mut right = 0;
        let mut map = BTreeMap::new();
        let mut total = 0_i64;
        for left in 0..n {
            while right < n && check(nums[right], &map) {
                *map.entry(nums[right]).or_insert(0) += 1;
                right += 1;
            }

            total += (right - left) as i64;

            if left == right {
                right += 1;
            } else {
                if map[&nums[left]] == 1 {
                    map.remove(&nums[left]);
                } else {
                    map.entry(nums[left]).and_modify(|v| *v -= 1);
                }
            }
        }

        total
    }
}

fn check(num: i32, map: &BTreeMap<i32, i32>) -> bool {
    if map.is_empty() {
        return true;
    }

    let (min, _) = map.first_key_value().unwrap();
    let (max, _) = map.last_key_value().unwrap();
    (min - num).abs() <= 2 && (max - num).abs() <= 2
}

struct Solution;

fn main() {
    println!("{}", Solution::continuous_subarrays(vec![5, 4, 2, 3]));
    println!("{}", Solution::continuous_subarrays(vec![1, 2, 3]));
}
