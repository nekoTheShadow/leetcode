impl Solution {
    pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
        let mut ret = 0;
        for i in 0..25 {
            let count_one = nums.iter().filter(|&&num| (num >> i) & 1 == 1).count();
            let bit = ((k >> i) & 1) as usize;
            if count_one % 2 != bit {
                ret += 1;
            }
        }
        ret
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::min_operations(vec![2, 1, 3, 4], 1));
    println!("{}", Solution::min_operations(vec![2, 0, 2, 0], 0));
    println!("{}", Solution::min_operations(vec![4], 7));
}
