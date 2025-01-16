impl Solution {
    pub fn xor_all_nums(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        if nums1.len() % 2 == 0 && nums2.len() % 2 != 0 {
            return nums1.into_iter().reduce(|acc, v| acc ^ v).unwrap();
        }
        if nums1.len() % 2 != 0 && nums2.len() % 2 == 0 {
            return nums2.into_iter().reduce(|acc, v| acc ^ v).unwrap();
        }
        if nums1.len() % 2 != 0 && nums2.len() % 2 != 0 {
            let v1 = nums1.into_iter().reduce(|acc, v| acc ^ v).unwrap();
            let v2 = nums2.into_iter().reduce(|acc, v| acc ^ v).unwrap();
            return v1 ^ v2;
        }
        0
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::xor_all_nums(vec![2, 1, 3], vec![10, 2, 5, 0]), 13);
    assert_eq!(Solution::xor_all_nums(vec![1, 2], vec![3, 4]), 0);
    assert_eq!(Solution::xor_all_nums(vec![25,29,3,10,0,15,2], vec![12]), 12);
}
