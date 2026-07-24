use itertools::Itertools;
use regex::Regex;

impl Solution {
    pub fn max_active_sections_after_trade(s: String) -> i32 {
        let mx = Regex::new("0+|1+")
            .unwrap()
            .find_iter(&format!("1{}1", &s))
            .tuple_windows()
            .filter_map(|(a, b, _c, d, _e)| {
                a.as_str()
                    .starts_with("1")
                    .then(|| b.end() - b.start() + d.end() - d.start())
            })
            .max();
        (s.chars().filter(|ch| *ch == '1').count() + mx.unwrap_or(0)) as i32
    }
}
struct Solution;

fn main() {
    println!(
        "{}",
        Solution::max_active_sections_after_trade("1".to_string())
    );
}

#[cfg(test)]
mod test {
    use crate::Solution;
    #[test]
    fn example1() {
        assert_eq!(
            Solution::max_active_sections_after_trade("01".to_string()),
            1
        )
    }
    #[test]
    fn example2() {
        assert_eq!(
            Solution::max_active_sections_after_trade("0100".to_string()),
            4
        )
    }
    #[test]
    fn example3() {
        assert_eq!(
            Solution::max_active_sections_after_trade("1000100".to_string()),
            7
        )
    }
    #[test]
    fn example4() {
        assert_eq!(
            Solution::max_active_sections_after_trade("01010".to_string()),
            4
        )
    }
}
