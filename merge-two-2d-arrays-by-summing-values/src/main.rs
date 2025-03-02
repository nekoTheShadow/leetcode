impl Solution {
    pub fn merge_arrays(nums1: Vec<Vec<i32>>, nums2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut i = 0;
        let mut j = 0;
        let mut ans = Vec::new();
        loop {
            match (nums1.get(i), nums2.get(j)) {
                (None, None) => break,
                (None, Some(a)) => {
                    ans.push(a.clone());
                    j += 1;
                }
                (Some(a), None) => {
                    ans.push(a.clone());
                    i += 1;
                }
                (Some(a1), Some(a2)) => {
                    let x1 = a1[0];
                    let v1 = a1[1];
                    let x2 = a2[0];
                    let v2 = a2[1];
                    match x1.cmp(&x2) {
                        std::cmp::Ordering::Less => {
                            ans.push(vec![x1, v1]);
                            i += 1;
                        }
                        std::cmp::Ordering::Equal => {
                            ans.push(vec![x1, v1 + v2]);
                            i += 1;
                            j += 1;
                        }
                        std::cmp::Ordering::Greater => {
                            ans.push(vec![x2, v2]);
                            j += 1;
                        }
                    }
                }
            }
        }

        ans
    }
}

struct Solution;

fn main() {
    testing(
        &[[1, 2], [2, 3], [4, 5]],
        &[[1, 4], [3, 2], [4, 1]],
        &[[1, 6], [2, 3], [3, 2], [4, 6]],
    );
    testing(
        &[[2, 4], [3, 6], [5, 5]],
        &[[1, 3], [4, 3]],
        &[[1, 3], [2, 4], [3, 6], [4, 3], [5, 5]],
    );
}

fn testing(nums1: &[[i32; 2]], nums2: &[[i32; 2]], expected: &[[i32; 2]]) {
    let actual = Solution::merge_arrays(
        nums1.iter().map(|a| a.to_vec()).collect(),
        nums2.iter().map(|a| a.to_vec()).collect(),
    );
    assert_eq!(actual, expected)
}
