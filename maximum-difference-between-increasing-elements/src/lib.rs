impl Solution {
    pub fn maximum_difference(nums: Vec<i32>) -> i32 {
        let mut min = std::i32::MAX;
        let mut ret = -1;
        for num in nums {
            if min < num {
                ret = std::cmp::max(ret, num - min);
            }
            min = std::cmp::min(min, num)
        }
        ret
    }
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        assert_eq!(Solution::maximum_difference(vec![7, 1, 5, 4]), 4);
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::maximum_difference(vec![9, 4, 3, 2]), -1);
    }

    #[test]
    fn example3() {
        assert_eq!(Solution::maximum_difference(vec![1, 5, 2, 10]), 9);
    }
}
