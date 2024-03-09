impl Solution {
    pub fn get_common(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        *nums1
            .iter()
            .find(|&num1| nums2.binary_search(&num1).is_ok())
            .unwrap_or(&-1)
    }
}
struct Solution {}

fn main() {
    println!("{}", Solution::get_common(vec![1, 2, 3], vec![2, 4]));
    println!(
        "{}",
        Solution::get_common(vec![1, 2, 3, 6], vec![2, 3, 4, 5])
    );
}
