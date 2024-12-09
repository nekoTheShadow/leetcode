impl Solution {
    pub fn is_array_special(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        let n = nums.len();
        let mut d = vec![0_i32; n];
        for i in 0..n - 1 {
            if nums[i] % 2 == nums[i + 1] % 2 {
                d[i + 1] = d[i] + 1;
            } else {
                d[i + 1] = d[i];
            }
        }

        queries
            .iter()
            .map(|query| d[query[1] as usize] - d[query[0] as usize] == 0)
            .collect()
    }
}

struct Solution;

fn main() {
    check(&[3, 4, 1, 2, 6], &[[0, 4]], &[false]);
    check(&[4, 3, 1, 6], &[[0, 2], [2, 3]], &[false, true]);
}

fn check(nums: &[i32], queries: &[[i32; 2]], expected: &[bool]) {
    let actual = Solution::is_array_special(
        nums.to_vec(),
        queries.iter().map(|query| query.to_vec()).collect(),
    );
    assert_eq!(expected, actual);
}
