impl Solution {
    pub fn largest_combination(candidates: Vec<i32>) -> i32 {
        (0..30)
            .map(|i| {
                candidates
                    .iter()
                    .filter(|candidate| *candidate & (1 << i) != 0)
                    .count()
            })
            .max()
            .unwrap() as i32
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::largest_combination(vec![16, 17, 71, 62, 12, 24, 14])
    );
    println!("{}", Solution::largest_combination(vec![8, 8]));
}
