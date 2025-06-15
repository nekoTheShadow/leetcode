impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        let digits = to_digits(num);
        maximize(&digits) - minimize(&digits)
    }
}

fn to_digits(mut num: i32) -> Vec<i32> {
    let mut digits = Vec::new();
    while num > 0 {
        digits.push(num % 10);
        num /= 10;
    }
    digits.reverse();
    digits
}

fn to_number(digits: &Vec<i32>) -> i32 {
    digits.iter().fold(0, |acc, digit| acc * 10 + *digit)
}

fn maximize(digits: &Vec<i32>) -> i32 {
    // 先頭から9以外の数値を探し、その数値を9に置換する
    if let Some(target) = digits.iter().find(|digit| **digit != 9) {
        to_number(
            &digits
                .iter()
                .map(|digit| if digit == target { 9 } else { *digit })
                .collect(),
        )
    } else {
        to_number(digits)
    }
}

fn minimize(digits: &Vec<i32>) -> i32 {
    // 先頭が1の場合、先頭から2以上の数値を探し、その数値を0に置換する
    // 先頭が1以外の場合、その数値を1に置換する
    let head = digits[0];
    if head == 1 {
        if let Some(target) = digits.iter().find(|digit| **digit >= 2) {
            to_number(
                &digits
                    .iter()
                    .map(|digit| if digit == target { 0 } else { *digit })
                    .collect(),
            )
        } else {
            to_number(digits)
        }
    } else {
        to_number(
            &digits
                .iter()
                .map(|&digit| if head == digit { 1 } else { digit })
                .collect(),
        )
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::max_diff(555), 888);
    assert_eq!(Solution::max_diff(9), 8);
}
