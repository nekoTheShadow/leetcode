impl Solution {
    pub fn minimum_mountain_removals(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        let n = nums.len();

        let a1 = Self::make_a(&nums);
        nums.reverse();
        let mut a2 = Self::make_a(&nums);
        a2.reverse();

        (0..n)
            .filter(|&i| a1[i] > 1 && a2[i] > 1)
            .map(|i| n + 1 - a1[i] - a2[i])
            .min()
            .unwrap() as i32
    }

    fn make_a(nums: &Vec<i32>) -> Vec<usize> {
        let n = nums.len();
        let mut a = vec![1; n];
        let mut lis = vec![nums[0]];

        for i in 1..nums.len() {
            let x = match lis.binary_search(&nums[i]) {
                Ok(x) => x,
                Err(x) => x,
            };

            if x == lis.len() {
                lis.push(nums[i]);
            } else {
                lis[x] = nums[i];
            }
            a[i] = lis.len();
        }

        a
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::minimum_mountain_removals(vec![1, 3, 1]));
    println!(
        "{}",
        Solution::minimum_mountain_removals(vec![2, 1, 1, 5, 6, 2, 3, 1])
    );
}
