use std::cmp::max;

impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        let arr = arr.iter().map(|&v| v as usize).collect::<Vec<_>>();
        let k = k as usize;
        let mut memo = vec![0; arr.len()];
        Self::f(&arr, k, &mut memo, 0) as i32
    }

    fn f(arr: &Vec<usize>, k: usize, memo: &mut Vec<usize>, cur: usize) -> usize{
        if cur==arr.len() {
            return 0;
        }
        if memo[cur] != 0 {
            return memo[cur];
        }

        let mut ret = 0;
        let mut mx = 0;
        for i in 0..k {
            if arr.len() <= cur+i {
                break
            }
            
            mx = max(mx, arr[cur+i]);
            ret = max(ret, mx*(i+1) + Self::f(arr, k, memo, cur+i+1));
        }

        memo[cur] = ret;
        ret
    }
}
struct Solution{}


fn main() {
    println!("{}", Solution::max_sum_after_partitioning(vec![1,15,7,9,2,5,10], 3));
    println!("{}", Solution::max_sum_after_partitioning(vec![1,4,1,5,7,3,6,1,9,9,3], 4));
    println!("{}", Solution::max_sum_after_partitioning(vec![1], 1));
}