use std::collections::HashMap;

impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        // h1 ... key = sum of digits, value = group size
        let mut h1 = HashMap::new();
        for x in 1..=n {
            *h1.entry(sum_of_digits(x)).or_insert(0) += 1;
        }

        // h2 ... key = group size, value = count
        let mut h2 = HashMap::new();
        for x in h1.values() {
            *h2.entry(*x).or_insert(0) += 1;
        }

        // group size が最大のグループの数を求める
        let (_max_size, max_count) = h2.iter().max_by_key(|(size, _count)| *size).unwrap();
        *max_count
    }
}

fn sum_of_digits(mut n: i32) -> i32 {
    let mut sum = 0;
    while n > 0 {
        sum += n % 10;
        n /= 10;
    }
    sum
}

struct Solution;

fn main() {
    assert_eq!(Solution::count_largest_group(13), 4);
    assert_eq!(Solution::count_largest_group(2), 2);
}
