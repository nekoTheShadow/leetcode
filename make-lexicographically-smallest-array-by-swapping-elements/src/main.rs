impl Solution {
    pub fn lexicographically_smallest_array(nums: Vec<i32>, limit: i32) -> Vec<i32> {
        let n = nums.len();

        let mut a = (0..n).map(|i| (i, nums[i])).collect::<Vec<_>>();
        a.sort_unstable_by_key(|(_i, v)| *v);

        let mut b = vec![0; n];
        for chunk in a.chunk_by(|(_i1, v1), (_i2, v2)| v2 - v1 <= limit) {
            let mut vs = chunk.iter().map(|(_i, v)| v).collect::<Vec<_>>();
            let mut is = chunk.iter().map(|(i, _v)| i).collect::<Vec<_>>();
            vs.sort();
            is.sort();
            for (i, v) in is.iter().zip(vs.iter()) {
                b[**i] = **v;
            }
        }
        b
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::lexicographically_smallest_array(vec![1, 5, 3, 9, 8], 2),
        vec![1, 3, 5, 8, 9]
    );
    assert_eq!(
        Solution::lexicographically_smallest_array(vec![1, 7, 6, 18, 2, 1], 3),
        vec![1, 6, 7, 18, 1, 2]
    );
    assert_eq!(
        Solution::lexicographically_smallest_array(vec![1, 7, 28, 19, 10], 3),
        vec![1, 7, 28, 19, 10]
    );
}
