impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        let mut set = std::collections::HashSet::new();
        for v in arr {
            if set.contains(&(v * 2)) || (v % 2 == 0 && set.contains(&(v / 2))) {
                return true;
            }
            set.insert(v);
        }
        false
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::check_if_exist(vec![10, 2, 5, 3]), true);
    assert_eq!(Solution::check_if_exist(vec![3, 1, 7, 11]), false);
}
