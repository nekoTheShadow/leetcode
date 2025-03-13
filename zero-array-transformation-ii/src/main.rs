impl Solution {
    pub fn min_zero_array(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> i32 {
        let n = queries.len() as i32;

        let mut ng = -1_i32;
        let mut ok = n + 1;
        while (ok - ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if is_ok(&nums, &queries, mi) {
                ok = mi;
            } else {
                ng = mi;
            }
        }

        if ok <= n {
            ok
        } else {
            -1
        }
    }
}

fn is_ok(nums: &Vec<i32>, queries: &Vec<Vec<i32>>, k: i32) -> bool {
    let n = nums.len();
    let mut imos = vec![0; n + 1];
    for i in 0..k {
        let query = &queries[i as usize];
        let l = query[0] as usize;
        let r = query[1] as usize;
        let v = query[2];

        imos[l] += v;
        imos[r + 1] -= v;
    }
    for i in 0..n {
        imos[i + 1] += imos[i];
    }
    (0..n).all(|i| nums[i] <= imos[i])
}

struct Solution;

fn main() {
    check!([2, 0, 2], [[0, 2, 1], [0, 2, 1], [1, 1, 3]], 2);
    check!([4, 3, 2, 1], [[1, 3, 2], [0, 2, 1]], -1);
}

#[macro_export]
macro_rules! check {
    ($nums:expr, $queries:expr, $expected:expr) => {
        let actual = Solution::min_zero_array(
            $nums.to_vec(),
            $queries.map(|query| query.to_vec()).to_vec(),
        );
        assert_eq!(actual, $expected)
    };
}
