impl Solution {
    pub fn min_increment_for_unique(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        nums.sort();
        
        let mut max = -1;
        let mut ret = 0;
        for num in nums {
            if max < num {
                max = num;
            } else {
                ret += max + 1 - num;
                max = max + 1;
            }
        }

        ret
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::min_increment_for_unique(vec![1, 2, 2]));
    println!(
        "{}",
        Solution::min_increment_for_unique(vec![3, 2, 1, 2, 1, 7])
    );
}
