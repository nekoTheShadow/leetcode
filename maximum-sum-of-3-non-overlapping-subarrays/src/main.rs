use std::collections::{BTreeMap, BTreeSet};

impl Solution {
    pub fn max_sum_of_three_subarrays(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let n = nums.len();
        let k = k as usize;
        let mut d = vec![0_i32; n + 1];
        for i in 0..n {
            d[i + 1] = d[i] + nums[i];
        }

        let mut l: BTreeMap<i32, BTreeSet<usize>> = BTreeMap::new();
        let mut r: BTreeMap<i32, BTreeSet<usize>> = BTreeMap::new();
        for x in k..n {
            if x + k <= n {
                r.entry(d[x + k] - d[x])
                    .or_insert(BTreeSet::new())
                    .insert(x);
            }
        }

        let mut max = -1;
        let mut ret = vec![usize::MAX, usize::MAX, usize::MAX];
        for x in 0..n {
            if let (Some((k1, v1)), Some((k2, v2))) = (l.last_key_value(), r.last_key_value()) {
                let total = *k1 + *k2 + (d[x + k] - d[x]);
                let buf = vec![*v1.first().unwrap(), x, *v2.first().unwrap()];
                if max < total {
                    max = total;
                    ret = buf;
                } else if max == total {
                    ret = std::cmp::min(ret, buf);
                }
            }

            if k <= x + 1 {
                l.entry(d[x + 1] - d[x + 1 - k])
                    .or_insert(BTreeSet::new())
                    .insert(x + 1 - k);
            }

            if x + k + k <= n {
                let key = d[x + k + k] - d[x + k];
                r.get_mut(&key).unwrap().remove(&(x + k));
                if r[&key].is_empty() {
                    r.remove(&key);
                }
            }
        }
        vec![ret[0] as i32, ret[1] as i32, ret[2] as i32]
    }
}

struct Solution;

fn main() {
    println!(
        "{:?}",
        Solution::max_sum_of_three_subarrays(vec![1, 2, 1, 2, 6, 7, 5, 1], 2)
    );
    println!(
        "{:?}",
        Solution::max_sum_of_three_subarrays(vec![1, 2, 1, 2, 1, 2, 1, 2, 1], 2)
    );
    println!(
        "{:?}",
        Solution::max_sum_of_three_subarrays(vec![7, 13, 20, 19, 19, 2, 10, 1, 1, 19], 3)
    );
}
