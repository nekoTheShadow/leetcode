struct BIT {
    tree: Vec<i64>,
}

impl BIT {
    fn new(size: usize) -> Self {
        BIT {
            tree: vec![0; size],
        }
    }

    fn add(&mut self, mut i: usize, delta: i64) {
        while i < self.tree.len() {
            self.tree[i] += delta;
            i += i & i.wrapping_neg();
        }
    }

    fn query(&mut self, mut i: usize) -> i64 {
        let mut sum = 0;
        while i > 0 {
            sum += self.tree[i];
            i -= i & i.wrapping_neg();
        }
        sum
    }
}

impl Solution {
    pub fn count_majority_subarrays(nums: Vec<i32>, target: i32) -> i64 {
        let n = nums.len();
        let offset = (n + 1) as i32;
        let mut bit = BIT::new(2 * n + 2);

        bit.add((0 + offset) as usize, 1);

        let mut ans = 0;
        let mut current_sum = 0_i32;
        for num in nums {
            if num == target {
                current_sum += 1;
            } else {
                current_sum -= 1;
            }
            ans += bit.query((current_sum + offset - 1) as usize);
            bit.add((current_sum + offset) as usize, 1);
        }

        ans
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
