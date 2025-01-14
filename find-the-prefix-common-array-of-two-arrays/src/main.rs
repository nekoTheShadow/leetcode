use std::collections::HashSet;

impl Solution {
    pub fn find_the_prefix_common_array(a: Vec<i32>, b: Vec<i32>) -> Vec<i32> {
        let mut s1 = HashSet::new();
        let mut s2 = HashSet::new();
        let mut t = HashSet::new();
        let mut counts = Vec::new();
        for (v1, v2) in a.iter().zip(b.iter()) {
            s1.insert(v1);
            s2.insert(v2);
            if s1.contains(v1) && s2.contains(v1) {
                t.insert(v1);
            }
            if s1.contains(v2) && s2.contains(v2) {
                t.insert(v2);
            }
            counts.push(t.len() as i32);
        }
        counts
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::find_the_prefix_common_array(vec![1, 3, 2, 4], vec![3, 1, 2, 4]),
        vec![0, 2, 3, 4]
    );
    assert_eq!(
        Solution::find_the_prefix_common_array(vec![2, 3, 1], vec![3, 1, 2]),
        vec![0, 1, 3]
    );
}
