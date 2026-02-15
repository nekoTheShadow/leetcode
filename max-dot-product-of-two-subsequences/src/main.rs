use std::collections::HashMap;

impl Solution {
    pub fn max_dot_product(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        f(&mut HashMap::new(), &nums1, &nums2, 0, 0, false).unwrap()
    }
}

fn f(
    memo: &mut HashMap<(usize, usize, bool), Option<i32>>,
    nums1: &[i32],
    nums2: &[i32],
    i: usize,
    j: usize,
    visited: bool,
) -> Option<i32> {
    if i >= nums1.len() || j >= nums2.len() {
        if visited {
            return Some(0);
        } else {
            return None;
        }
    }

    let key = (i, j, visited);
    if let Some(x) = memo.get(&key) {
        return *x;
    }

    let x1 = f(memo, nums1, nums2, i + 1, j + 1, true).map(|v| v + (nums1[i] * nums2[j]));
    let x2 = f(memo, nums1, nums2, i + 1, j, visited);
    let x3 = f(memo, nums1, nums2, i, j + 1, visited);
    let x = [x1, x2, x3].into_iter().flatten().max();
    memo.insert(key, x);
    x
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let nums1 = [2, 1, -2, 5];
        let nums2 = [3, 0, -6];
        let output = 18;
        assert_eq!(
            Solution::max_dot_product(nums1.to_vec(), nums2.to_vec()),
            output
        )
    }

    #[test]
    fn example2() {
        let nums1 = [3, -2];
        let nums2 = [2, -6, 7];
        let output = 21;
        assert_eq!(
            Solution::max_dot_product(nums1.to_vec(), nums2.to_vec()),
            output
        )
    }

    #[test]
    fn example3() {
        let nums1 = [-1, -1];
        let nums2 = [1, 1];
        let output = -1;
        assert_eq!(
            Solution::max_dot_product(nums1.to_vec(), nums2.to_vec()),
            output
        )
    }
}
