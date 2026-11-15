use std::collections::VecDeque;

impl Solution {
    pub fn count_non_decreasing_subarrays(nums: Vec<i32>, k: i32) -> i64 {
        let n = nums.len();
        let k = k as i64;

        let mut cost = 0_i64;
        let mut ans = 0_i64;
        let mut dq = VecDeque::new();
        let mut r = n - 1;

        for l in (0..n).rev() {
            while dq.back().is_some_and(|&i| nums[i] < nums[l]) {
                let i = dq.pop_back().unwrap();
                let right = *dq.back().unwrap_or(&(r + 1));

                cost += (right - i) as i64 * (nums[l] - nums[i]) as i64;
            }

            dq.push_back(l);

            while cost > k {
                let i = *dq.front().unwrap();

                cost -= (nums[i] - nums[r]) as i64;

                if i == r {
                    dq.pop_front();
                }

                r -= 1;
            }

            ans += (r - l + 1) as i64;
        }

        ans
    }
}
struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let nums: Vec<i32> = vec![6, 3, 1, 2, 4, 4];
        let k: i32 = 7;
        assert_eq!(Solution::count_non_decreasing_subarrays(nums, k), 17);
    }

    #[test]
    fn example2() {
        let nums: Vec<i32> = vec![6, 3, 1, 3, 6];
        let k: i32 = 4;
        assert_eq!(Solution::count_non_decreasing_subarrays(nums, k), 12);
    }

    #[test]
    fn ng1() {
        let nums: Vec<i32> = vec![12, 20];
        let k: i32 = 4;
        assert_eq!(Solution::count_non_decreasing_subarrays(nums, k), 3);
    }
}
