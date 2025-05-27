impl Solution {
    pub fn difference_of_sums(n: i32, m: i32) -> i32 {
        let a = n / m; // mで割り切れる数の個数
        let num2 = (a * (a + 1) * m) / 2; // mで割り切れる数の和
        let num3 = (1 + n) * n / 2; // [1,n]の和
        let num1 = num3 - num2; // mで割り切れない数の和
        num1 - num2
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::difference_of_sums(10, 3), 19);
    assert_eq!(Solution::difference_of_sums(5, 6), 15);
    assert_eq!(Solution::difference_of_sums(5, 1), -15);
}
