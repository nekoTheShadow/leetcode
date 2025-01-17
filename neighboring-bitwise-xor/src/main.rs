impl Solution {
    pub fn does_valid_array_exist(derived: Vec<i32>) -> bool {
        check(0, &derived) || check(1, &derived)
    }
}

fn check(start: i32, derived: &[i32]) -> bool {
    let mut a = vec![start];
    let n = derived.len();
    for i in 0..n - 1 {
        a.push(a[i] ^ derived[i]);
    }
    (a[0] ^ a[n - 1]) == derived[n - 1]
}

struct Solution;

fn main() {
    assert_eq!(Solution::does_valid_array_exist(vec![1, 1, 0]), true);
    assert_eq!(Solution::does_valid_array_exist(vec![1, 1]), true);
    assert_eq!(Solution::does_valid_array_exist(vec![1, 0]), false);
}
