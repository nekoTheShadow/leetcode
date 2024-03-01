impl Solution {
    pub fn maximum_odd_binary_number(s: String) -> String {
        let one = s.chars().filter(|&c| c == '1').count();
        let zero = s.len() - one;

        let mut s = String::new();
        for _ in 0..one - 1 {
            s.push('1')
        }
        for _ in 0..zero {
            s.push('0')
        }
        s.push('1');
        s
    }
}

struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::maximum_odd_binary_number(String::from("010"))
    );
    println!(
        "{}",
        Solution::maximum_odd_binary_number(String::from("0101"))
    );
}
