impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if n == 1 || nums[0] < nums[n - 1] {
            return nums[0];
        }
        let (l, r) = nums.split_at(n / 2);
        std::cmp::min(Self::find_min(l.to_vec()), Self::find_min(r.to_vec()))
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
        assert_eq!(Solution::find_min(vec![1, 3, 5]), 1)
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::find_min(vec![2, 2, 2, 0, 1]), 0)
    }
}
