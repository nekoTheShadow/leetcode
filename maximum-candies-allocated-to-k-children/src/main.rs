impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        let candies = candies
            .iter()
            .map(|candy| *candy as i64)
            .collect::<Vec<_>>();
        let mut ok = 0;
        let mut ng = *candies.iter().max().unwrap() + 1;
        while (ok - ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if candies.iter().map(|candy| candy / mi).sum::<i64>() >= k {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        ok as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_candies(vec![5, 8, 6], 3), 5);
    assert_eq!(Solution::maximum_candies(vec![2, 5], 11), 0);
}
