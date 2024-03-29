impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i64 {
        let n = nums.len();
        let &max = nums.iter().max().unwrap();

        let mut d = vec![0; n+1];
        for i in 0..n {
            if nums[i] == max {
                d[i+1] = d[i] + 1;
            } else {
                d[i+1] = d[i] + 0;
            }
        }

        let mut ret = 0;
        for i in 0..n {
            let mut ok = i;
            let mut ng = n+1;
            while ok.abs_diff(ng) > 1 {
                let mi = (ok + ng) / 2;
                if d[mi] - d[i] < k {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            ret += n - ok;
        }

        ret as i64
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::count_subarrays(vec![1,3,2,3,3], 2));
    println!("{}", Solution::count_subarrays(vec![1,4,2,1], 3));
}
