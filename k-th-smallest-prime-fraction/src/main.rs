impl Solution {
    pub fn kth_smallest_prime_fraction(arr: Vec<i32>, k: i32) -> Vec<i32> {
        let k = k as usize;

        let mut rationals = Vec::new();
        for i in 0..arr.len() {
            for j in i + 1..arr.len() {
                rationals.push((arr[i], arr[j]));
            }
        }
        rationals.sort_by(|(a, b), (c, d)| (a * d).cmp(&(b * c)));
        vec![rationals[k - 1].0, rationals[k - 1].1]
    }
}

struct Solution;

fn main() {
    println!(
        "{:?}",
        Solution::kth_smallest_prime_fraction(vec![1, 2, 3, 5], 3)
    );
    println!("{:?}", Solution::kth_smallest_prime_fraction(vec![1, 7], 1));
}
