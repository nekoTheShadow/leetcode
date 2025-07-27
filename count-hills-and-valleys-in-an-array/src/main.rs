use itertools::Itertools;

impl Solution {
    pub fn count_hill_valley(nums: Vec<i32>) -> i32 {
        nums.iter()
            .dedup()
            .tuple_windows::<(_, _, _)>()
            .filter(|(a, b, c)| (a < b && b > c) || (a > b && b < c))
            .count() as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::count_hill_valley(vec![2, 4, 1, 1, 6, 5]), 3);
    assert_eq!(Solution::count_hill_valley(vec![6, 6, 5, 5, 4, 1]), 0);
}
