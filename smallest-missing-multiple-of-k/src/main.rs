use std::collections::HashSet;

impl Solution {
    pub fn missing_multiple(nums: Vec<i32>, k: i32) -> i32 {
        let set = nums.iter().collect::<HashSet<_>>();
        let mut v = k;
        while set.contains(&v) {
            v += k;
        }
        v
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let nums = [8, 2, 3, 4, 6];
        let k = 2;
        let output = 10;
        assert_eq!(Solution::missing_multiple(nums.to_vec(), k), output);
    }

    #[test]
    fn example2() {
        let nums = [1, 4, 7, 10, 15];
        let k = 5;
        let output = 5;
        assert_eq!(Solution::missing_multiple(nums.to_vec(), k), output);
    }
}
