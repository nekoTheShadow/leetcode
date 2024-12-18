impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        prices
            .iter()
            .enumerate()
            .map(|(i, p1)| {
                if let Some(min) = prices[i + 1..].iter().find(|p2| **p2 <= *p1) {
                    p1 - min
                } else {
                    *p1
                }
            })
            .collect()
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::final_prices(vec![8, 4, 6, 2, 3]),
        vec![4, 2, 4, 2, 3]
    );
    assert_eq!(
        Solution::final_prices(vec![1, 2, 3, 4, 5]),
        vec![1, 2, 3, 4, 5]
    );
    assert_eq!(Solution::final_prices(vec![10, 1, 1, 6]), vec![9, 0, 1, 6]);
}
