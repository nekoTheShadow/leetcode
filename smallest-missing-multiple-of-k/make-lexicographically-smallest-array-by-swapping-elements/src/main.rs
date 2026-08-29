use std::println;

use itertools::Itertools;

impl Solution {
    pub fn lexicographically_smallest_array(nums: Vec<i32>, limit: i32) -> Vec<i32> {
        let n = nums.len();
        let tuples = nums
            .into_iter()
            .enumerate()
            .sorted_unstable_by_key(|(_i, v)| *v)
            .collect::<Vec<_>>();

        let mut ret = vec![0i32; n];
        for group in tuples.chunk_by(|(_i1, v1), (_i2, v2)| v2 - v1 <= limit) {
            for (i, v) in group
                .iter()
                .map(|(i, _v)| i)
                .sorted()
                .zip(group.iter().map(|(_i, v)| v))
            {
                ret[*i] = *v;
            }
        }
        ret
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
        let nums = [1, 5, 3, 9, 8];
        let limit = 2;
        let output = [1, 3, 5, 8, 9];
        assert_eq!(
            Solution::lexicographically_smallest_array(nums.to_vec(), limit),
            output.to_vec()
        );
    }

    #[test]
    fn example2() {
        let nums = [1, 7, 6, 18, 2, 1];
        let limit = 3;
        let output = [1, 6, 7, 18, 1, 2];
        assert_eq!(
            Solution::lexicographically_smallest_array(nums.to_vec(), limit),
            output.to_vec()
        );
    }

    #[test]
    fn example3() {
        let nums = [1, 7, 28, 19, 10];
        let limit = 3;
        let output = [1, 7, 28, 19, 10];
        assert_eq!(
            Solution::lexicographically_smallest_array(nums.to_vec(), limit),
            output.to_vec()
        );
    }
}
