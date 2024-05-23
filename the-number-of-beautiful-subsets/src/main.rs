impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        let mut count = 0;
        Self::dfs(&mut Vec::new(), &nums, k, &mut count);
        count
    }

    pub fn dfs(set: &mut Vec<i32>, nums: &[i32], k: i32, count: &mut i32) {
        if let Some((head, tail)) = nums.split_first() {
            Self::dfs(set, tail, k, count);
            if set.iter().all(|v| (v-head).abs() != k) {
                set.push(*head);
                Self::dfs(set, tail, k, count);
                set.pop();
            }            
        } else {
            if !set.is_empty() {
                *count += 1;
            }
        }
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::beautiful_subsets(vec![2, 4, 6], 2));
    println!("{}", Solution::beautiful_subsets(vec![1], 1));
}
