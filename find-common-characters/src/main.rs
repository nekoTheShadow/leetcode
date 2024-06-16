impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        ('a'..='z')
            .flat_map(|c| {
                let n = words
                    .iter()
                    .map(|word| word.matches(c).count())
                    .min()
                    .unwrap();
                std::iter::repeat(c.to_string()).take(n)
            })
            .collect()
    }
}

struct Solution;

fn main() {
    println!(
        "{:?}",
        Solution::common_chars(["bella", "label", "roller"].map(|s| s.to_string()).to_vec())
    );
    println!(
        "{:?}",
        Solution::common_chars(["cool", "lock", "cook"].map(|s| s.to_string()).to_vec())
    );
}
