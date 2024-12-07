impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        let mut ng = 0_i32;
        let mut ok = 1000000001_i32;
        while (ok - ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if nums
                .iter()
                .map(|num| {
                    if num % mi == 0 {
                        num / mi - 1
                    } else {
                        num / mi
                    }
                })
                .sum::<i32>()
                <= max_operations
            {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        ok
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::minimum_size(vec![9], 2), 3);
    assert_eq!(Solution::minimum_size(vec![2, 4, 8, 2], 4), 2);
}
