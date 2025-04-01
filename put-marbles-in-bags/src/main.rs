use itertools::Itertools;

impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        let mut d = weights
            .iter()
            .zip(weights[1..].iter())
            .map(|(x, y)| (x + y) as i64)
            .collect::<Vec<_>>();
        d.sort();

        let k = k as usize;
        let min = d.iter().take(k - 1).sum::<i64>();
        let max = d.iter().tail(k - 1).sum::<i64>();
        max - min
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::put_marbles(vec![1, 3, 5, 1], 2), 4);
    assert_eq!(Solution::put_marbles(vec![1, 3], 2), 0);
}
