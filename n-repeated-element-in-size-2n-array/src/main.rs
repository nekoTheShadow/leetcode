use std::collections::HashSet;

impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        let mut set = HashSet::new();
        for num in nums {
            if set.contains(&num) {
                return num;
            }
            set.insert(num);
        }
        unreachable!()
    }
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
        let nums = [1, 2, 3, 3];
        let output = 3;
        assert_eq!(Solution::repeated_n_times(nums.to_vec()), output);
    }
    #[test]
    fn example2() {
        let nums = [2, 1, 2, 5, 3, 2];
        let output = 2;
        assert_eq!(Solution::repeated_n_times(nums.to_vec()), output);
    }
    #[test]
    fn example3() {
        let nums = [5, 1, 5, 2, 5, 3, 5, 4];
        let output = 5;
        assert_eq!(Solution::repeated_n_times(nums.to_vec()), output);
    }
}
