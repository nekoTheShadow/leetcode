impl Solution {
    pub fn find_kth_bit(n: i32, k: i32) -> char {
        let mut s = "0".to_string();
        for _ in 1..n {
            s = format!(
                "{}1{}",
                s,
                &s.chars()
                    .map(|c| if c == '1' { '0' } else { '1' })
                    .rev()
                    .collect::<String>()
            )
            .to_string();
        }
        s.chars().nth((k - 1) as usize).unwrap()
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::find_kth_bit(3, 1), '0');
    assert_eq!(Solution::find_kth_bit(4, 11), '1');
}
