use itertools::Itertools;

impl Solution {
    pub fn get_sneaky_numbers(nums: Vec<i32>) -> Vec<i32> {
        nums.iter()
            .sorted()
            .tuple_windows()
            .filter(|&(a, b)| a == b)
            .map(|(a, _b)| *a)
            .collect()
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn example1() {
        let mut res = Solution::get_sneaky_numbers(vec![0, 1, 1, 0]);
        res.sort();
        assert_eq!(res, vec![0, 1]);
    }

    #[test]
    fn example2() {
        let mut res = Solution::get_sneaky_numbers(vec![0, 3, 2, 1, 3, 2]);
        res.sort();
        assert_eq!(res, vec![2, 3]);
    }

    #[test]
    fn example3() {
        let mut res = Solution::get_sneaky_numbers(vec![7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2]);
        res.sort();
        assert_eq!(res, vec![4, 5]);
    }
}
