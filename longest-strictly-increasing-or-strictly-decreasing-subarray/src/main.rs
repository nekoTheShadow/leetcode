impl Solution {
    pub fn longest_monotonic_subarray(nums: Vec<i32>) -> i32 {
        let mut s = Vec::new();
        let mut t = Vec::new();
        let mut max_size = 0;
        for v in nums {
            push(&mut s, v, |pre, cur| pre < cur);
            push(&mut t, v, |pre, cur| pre > cur);
            max_size = std::cmp::max(max_size, s.len());
            max_size = std::cmp::max(max_size, t.len());
        }
        max_size as i32
    }
}

fn push<F: Fn(i32, i32) -> bool>(s: &mut Vec<i32>, v: i32, pred: F) {
    if let Some(&pre) = s.last() {
        if !pred(pre, v) {
            s.clear();
        }
    }
    s.push(v);
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::longest_monotonic_subarray(vec![1, 4, 3, 3, 2])
    );
    println!("{}", Solution::longest_monotonic_subarray(vec![3, 3, 3, 3]));
    println!("{}", Solution::longest_monotonic_subarray(vec![3, 2, 1]));
}
