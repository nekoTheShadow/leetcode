use itertools::Itertools;

use std::cmp::min;

impl Solution {
    pub fn min_cost(basket1: Vec<i32>, basket2: Vec<i32>) -> i64 {
        let basket1 = basket1
            .into_iter()
            .map(|fruit| fruit as i64)
            .sorted()
            .collect::<Vec<_>>();
        let basket2 = basket2
            .into_iter()
            .map(|fruit| fruit as i64)
            .sorted()
            .collect::<Vec<_>>();

        let counter = basket1.iter().chain(&basket2).counts();
        if !counter.values().all(|count| count % 2 == 0) {
            return -1;
        }

        let basket3 = counter
            .iter()
            .flat_map(|(fruit, count)| std::iter::repeat_n(**fruit, count / 2))
            .sorted()
            .collect::<Vec<_>>();
        let min_fruit = basket3[0];
        min(
            calc(&basket1, &basket3, min_fruit),
            calc(&basket2, &basket3, min_fruit),
        )
    }
}

fn calc(basket1: &Vec<i64>, basket2: &Vec<i64>, min_fruit: i64) -> i64 {
    let mut i1 = 0;
    let mut i2 = 0;
    let mut diff1 = Vec::new();
    let mut diff2 = Vec::new();
    while let (Some(&x1), Some(&x2)) = (basket1.get(i1), basket2.get(i2)) {
        if x1 == x2 {
            i1 += 1;
            i2 += 1;
        } else if x1 < x2 {
            diff1.push(x1);
            i1 += 1;
        } else {
            diff2.push(x2);
            i2 += 1;
        }
    }

    diff1.extend((i1..basket1.len()).map(|i| basket1[i]));
    diff2.extend((i2..basket2.len()).map(|i| basket2[i]));

    diff1
        .iter()
        .zip(diff2.iter().rev())
        .map(|(x1, x2)| min(min(*x1, *x2), min_fruit * 2))
        .sum()
}
struct Solution;

fn main() {
    assert_eq!(Solution::min_cost(vec![4, 2, 2, 2], vec![1, 4, 1, 2]), 1);
    assert_eq!(Solution::min_cost(vec![2, 3, 4, 1], vec![3, 2, 5, 1]), -1);

    let basket1 = vec![84, 80, 43, 8, 80, 88, 43, 14, 100, 88];
    let basket2 = vec![32, 32, 42, 68, 68, 100, 42, 84, 14, 8];
    assert_eq!(Solution::min_cost(basket1, basket2), 48)
}
