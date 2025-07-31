use std::collections::HashSet;

impl Solution {
    pub fn subarray_bitwise_o_rs(arr: Vec<i32>) -> i32 {
        let mut set: HashSet<i32> = HashSet::new();
        let mut pre: HashSet<i32> = HashSet::new();
        for v in arr {
            let mut cur = HashSet::new();
            for bit in pre {
                cur.insert(bit | v);
            }
            cur.insert(v);

            set.extend(cur.iter());
            pre = cur;
        }
        set.len() as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::subarray_bitwise_o_rs(vec![0]), 1);
    assert_eq!(Solution::subarray_bitwise_o_rs(vec![1, 1, 2]), 3);
    assert_eq!(Solution::subarray_bitwise_o_rs(vec![1, 2, 4]), 6);
}
