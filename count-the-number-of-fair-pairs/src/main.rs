impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        let mut nums = nums;
        nums.sort();

        let mut ret = 0_i64;
        let mut streak = Vec::new();
        for num in nums {
            let l = streak.partition_point(|n| n + num < lower);
            let r = streak.partition_point(|n| n + num <= upper);
            ret += (r - l) as i64;
            streak.push(num);
        }
        ret
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::count_fair_pairs(vec![0, 1, 7, 4, 4, 5], 3, 6)
    );
    println!(
        "{}",
        Solution::count_fair_pairs(vec![1, 7, 9, 2, 5], 11, 11)
    );
}
