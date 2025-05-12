use itertools::{iproduct, Itertools};

impl Solution {
    pub fn find_even_numbers(digits: Vec<i32>) -> Vec<i32> {
        let n = digits.len();
        let mut numbers = Vec::new();
        for (i, j, k) in iproduct!(0..n, 0..n, 0..n) {
            if i == j || j == k || k == i {
                continue;
            }
            if digits[i] == 0 {
                continue;
            }
            if digits[k] % 2 == 0 {
                numbers.push(100 * digits[i] + 10 * digits[j] + digits[k]);
            }
        }
        numbers.into_iter().unique().sorted().collect()
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::find_even_numbers(vec![2, 1, 3, 0]),
        vec![102, 120, 130, 132, 210, 230, 302, 310, 312, 320]
    );
    assert_eq!(
        Solution::find_even_numbers(vec![2, 2, 8, 8, 2]),
        vec![222, 228, 282, 288, 822, 828, 882]
    );
}
