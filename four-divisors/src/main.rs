use std::collections::HashSet;

impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        nums.iter()
            .map(|num| get_divisors(*num))
            .filter(|divisors| divisors.len() == 4)
            .map(|divisors| divisors.iter().sum::<i32>())
            .sum()
    }
}

fn get_divisors(n: i32) -> HashSet<i32> {
    (1..)
        .take_while(|x| x * x <= n)
        .filter(|x| n % x == 0)
        .flat_map(|x| [x, n / x])
        .collect::<HashSet<_>>()
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let nums = [21, 4, 7];
        let output = 32;
        assert_eq!(Solution::sum_four_divisors(nums.to_vec()), output)
    }

    #[test]
    fn example2() {
        let nums = [21, 21];
        let output = 64;
        assert_eq!(Solution::sum_four_divisors(nums.to_vec()), output)
    }

    #[test]
    fn example3() {
        let nums = [1, 2, 3, 4, 5];
        let output = 0;
        assert_eq!(Solution::sum_four_divisors(nums.to_vec()), output)
    }
}
