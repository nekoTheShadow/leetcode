use std::collections::HashSet;

impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        let set = banned.iter().collect::<HashSet<_>>();
        let mut count = 0;
        let mut max_sum = max_sum;
        for v in 1..=n {
            if set.contains(&v) {
                continue;
            }
            if max_sum - v < 0 {
                break;
            }
            max_sum -= v;
            count += 1;
        }
        count
    }
}

struct Solution;

fn main() {
    assert_eq!(2, Solution::max_count(vec![1, 6, 5], 5, 6));
    assert_eq!(0, Solution::max_count(vec![1, 2, 3, 4, 5, 6, 7], 8, 1));
    assert_eq!(7, Solution::max_count(vec![11], 7, 50));
}
