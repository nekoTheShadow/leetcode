impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        let pairs = s1
            .chars()
            .zip(s2.chars())
            .filter(|&(c1, c2)| c1 != c2)
            .collect::<Vec<_>>();

        match pairs.len() {
            0 => true,
            2 => {
                let (a1, b1) = pairs[0];
                let (a2, b2) = pairs[1];
                a1 == b2 && a2 == b1
            }
            _ => false,
        }
    }
}

struct Solution;

fn main() {
    testing("bank", "kanb", true);
    testing("attack", "defend", false);
    testing("kelb", "kelb", true);
}

fn testing(s1: &str, s2: &str, expected: bool) {
    assert_eq!(Solution::are_almost_equal(s1.into(), s2.into()), expected)
}
