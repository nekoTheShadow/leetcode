impl Solution {
    pub fn sum_of_squares(nums: Vec<i32>) -> i32 {
        let n = nums.len();

        let mut tot = 0;
        let mut x = 1;
        while x * x <= n {
            if n % x == 0 {
                let y = n / x;
                tot += nums[x - 1] * nums[x - 1];
                if x != y {
                    tot += nums[y - 1] * nums[y - 1];
                }
            }
            x += 1;
        }
        tot
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
        let nums = [1, 2, 3, 4];
        let output = 21;
        assert_eq!(Solution::sum_of_squares(nums.to_vec()), output)
    }

    #[test]
    fn example2() {
        let nums = [2, 7, 1, 19, 18, 3];
        let output = 63;
        assert_eq!(Solution::sum_of_squares(nums.to_vec()), output)
    }
}
