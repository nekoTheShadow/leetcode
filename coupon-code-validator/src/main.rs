use itertools::Itertools;
use regex::Regex;

impl Solution {
    pub fn validate_coupons(
        codes: Vec<String>,
        business_lines: Vec<String>,
        is_actives: Vec<bool>,
    ) -> Vec<String> {
        (0..codes.len())
            .map(|i| (codes[i].clone(), business_lines[i].clone(), is_actives[i]))
            .filter(|(code, business_line, is_active)| {
                valid_coupon(&code, &business_line, *is_active)
            })
            .sorted_unstable_by_key(|(code, business_line, _)| {
                (business_line_rank(business_line), code.clone())
            })
            .map(|(code, _, _)| code)
            .collect()
    }
}

const BUSSINESS_LINES: &[&str] = &["electronics", "grocery", "pharmacy", "restaurant"];

fn valid_coupon(code: &str, business_line: &str, is_active: bool) -> bool {
    valid_code(code) && valid_business_line(business_line) && is_active
}

fn valid_code(code: &str) -> bool {
    Regex::new("^[A-Za-z0-9_]+$").unwrap().is_match(&code)
}

fn valid_business_line(business_line: &str) -> bool {
    BUSSINESS_LINES
        .iter()
        .any(|target| *target == business_line)
}

pub fn business_line_rank(business_line: &str) -> usize {
    (0..BUSSINESS_LINES.len())
        .find(|i| BUSSINESS_LINES[*i] == business_line)
        .unwrap()
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {

    use crate::Solution;

    #[test]
    fn example1() {
        let code = ["SAVE20", "", "PHARMA5", "SAVE@20"];
        let business_line = ["restaurant", "grocery", "pharmacy", "restaurant"];
        let is_active = [true, true, true, true];
        let output = ["PHARMA5", "SAVE20"];
        assert_eq!(
            Solution::validate_coupons(
                code.map(|s| s.to_string()).to_vec(),
                business_line.map(|s| s.to_string()).to_vec(),
                is_active.to_vec()
            ),
            output.to_vec()
        );
    }

    #[test]
    fn example2() {
        let code = ["GROCERY15", "ELECTRONICS_50", "DISCOUNT10"];
        let business_line = ["grocery", "electronics", "invalid"];
        let is_active = [false, true, true];
        let output = ["ELECTRONICS_50"];
        assert_eq!(
            Solution::validate_coupons(
                code.map(|s| s.to_string()).to_vec(),
                business_line.map(|s| s.to_string()).to_vec(),
                is_active.to_vec()
            ),
            output.to_vec()
        );
    }
}
