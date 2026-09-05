impl Solution {
    pub fn count_majority_subarrays(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        let mut d = vec![0; n + 1];

        for i in 0..n {
            if nums[i] == target {
                d[i + 1] += d[i] + 1;
            } else {
                d[i + 1] += d[i];
            }
        }

        let mut count = 0;
        for i in 0..n {
            for j in (i + 1)..(n + 1) {
                if j - i < (d[j] - d[i]) * 2  {
                    count += 1;
                }
            }
        }
        count
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
        assert_eq!(Solution::count_majority_subarrays(vec![1, 2, 2, 3], 2), 5)
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::count_majority_subarrays(vec![1, 1, 1, 1], 1), 10)
    }

    #[test]
    fn example3() {
        assert_eq!(Solution::count_majority_subarrays(vec![1, 2, 3], 4), 0)
    }
}
