use std::cmp::{max, min};

const INF: i32 = 1_000_000_000 + 7;

impl Solution {
    pub fn max_difference(s: String, k: i32) -> i32 {
        let n = s.len();
        let digits = s
            .chars()
            .map(|ch| ch as i32 - '0' as i32)
            .collect::<Vec<_>>();
        let mut max_diff = -INF;

        for a in 0..5 {
            for b in 0..5 {
                if a == b {
                    continue;
                }

                let mut cnt_a = 0;
                let mut cnt_b = 0;
                let mut pre_a = 0;
                let mut pre_b = 0;
                let mut left = -1;
                let mut best = vec![INF; 4];

                for right in 0..n {
                    if digits[right] == a {
                        cnt_a += 1;
                    }
                    if digits[right] == b {
                        cnt_b += 1;
                    }

                    while (right as i32 - left) >= k && (cnt_b - pre_b) >= 2 {
                        let left_status = get_status(pre_a, pre_b) as usize;
                        best[left_status] = min(best[left_status], pre_a - pre_b);
                        left += 1;

                        if digits[left as usize] == a {
                            pre_a += 1;
                        }
                        if digits[left as usize] == b {
                            pre_b += 1;
                        }
                    }

                    let right_status = get_status(cnt_a, cnt_b) as usize;
                    let target_status = right_status ^ 2;
                    if best[target_status] != INF {
                        let diff = (cnt_a - cnt_b) - best[target_status];
                        max_diff = max(max_diff, diff)
                    }
                }
            }
        }

        max_diff
    }
}

fn get_status(cnt_a: i32, cnt_b: i32) -> i32 {
    ((cnt_a & 1) << 1) | (cnt_b & 1)
}

struct Solution;

fn main() {
    assert_eq!(Solution::max_difference("12233".into(), 4), -1);
    assert_eq!(Solution::max_difference("1122211".into(), 3), 1);
    assert_eq!(Solution::max_difference("110".into(), 3), -1);
    assert_eq!(Solution::max_difference("2000222014".into(), 7), 1);
}
