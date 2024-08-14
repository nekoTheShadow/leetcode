impl Solution {
    pub fn smallest_distance_pair(nums: Vec<i32>, k: i32) -> i32 {
        let mut nums = nums;
        nums.sort();

        let mut ok = -1;
        let mut ng = 10000000 + 1;
        while i32::abs(ok - ng) > 1 {
            let mi = (ok + ng) / 2;
            if Self::count(&nums, mi) < k {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        ok
    }

    pub fn count(nums: &[i32], m: i32) -> i32 {
        let mut vals = Vec::new();
        let mut count = 0;
        for b in nums {
            let n = vals.len() as i32;
            let mut ng = -1_i32;
            let mut ok = n;
            while i32::abs(ok - ng) > 1 {
                let mi = (ok + ng) / 2;
                if b - m < vals[mi as usize] {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }

            count += n - ok;
            vals.push(*b);
        }
        count
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::smallest_distance_pair(vec![1, 3, 1], 1));
    println!("{}", Solution::smallest_distance_pair(vec![1, 1, 1], 2));
    println!("{}", Solution::smallest_distance_pair(vec![1, 6, 1], 3));
    println!("{}", Solution::smallest_distance_pair(vec![62, 100, 4], 2));
}
