use std::collections::HashSet;

impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let set1 = nums1.into_iter().collect::<HashSet<_>>();
        nums2
            .into_iter()
            .filter(|num2| set1.contains(num2))
            .fold(HashSet::new(), |mut acc, num2| {
                acc.insert(num2);
                acc
            })
            .into_iter()
            .collect::<Vec<_>>()
    }
}

struct Solution {}

fn main() {
    println!("{:?}", Solution::intersection(vec![1, 2, 2, 1], vec![2, 2]));
    println!(
        "{:?}",
        Solution::intersection(vec![4, 9, 5], vec![9, 4, 9, 8, 4])
    );
}
