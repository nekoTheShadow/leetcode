impl Solution {
    pub fn smallest_index(nums: Vec<i32>) -> i32 {
        (0..)
            .zip(nums.into_iter())
            .find_map(|(i, num)| (i == sum_digits(num)).then_some(i))
            .unwrap_or(-1)
    }
}

fn sum_digits(mut x: i32) -> i32 {
    let mut sum = 0;
    while x > 0 {
        sum += x % 10;
        x /= 10;
    }
    sum
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
        let nums = [1, 3, 2];
        assert_eq!(Solution::smallest_index(nums.to_vec()), 2);
    }
    #[test]
    fn example2() {
        let nums = [1, 10, 11];
        assert_eq!(Solution::smallest_index(nums.to_vec()), 1);
    }

    #[test]
    fn example3() {
        let nums = [1, 2, 3];
        assert_eq!(Solution::smallest_index(nums.to_vec()), -1);
    }
}
