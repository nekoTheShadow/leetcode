use itertools::iproduct;

impl Solution {
    pub fn count_triples(n: i32) -> i32 {
        iproduct!(1..=n,1..=n, 1..=n)
            .filter(|(a, b, c)| a * a + b * b == c * c)
            .count() as i32
    }
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        assert_eq!(Solution::count_triples(5), 2)
    }

        #[test]
    fn example2() {
        assert_eq!(Solution::count_triples(10), 4)
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}
