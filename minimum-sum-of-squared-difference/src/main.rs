impl Solution {
    pub fn min_sum_square_diff(nums1: Vec<i32>, nums2: Vec<i32>, k1: i32, k2: i32) -> i64 {
        let diffs = nums1
            .iter()
            .zip(nums2.iter())
            .map(|(a, b)| (a - b).abs() as usize)
            .collect::<Vec<_>>();
        let n = *diffs.iter().max().unwrap();

        let mut backet = vec![0; n + 1];
        for diff in diffs {
            backet[diff] += 1;
        }

        let mut k = (k1 + k2) as usize;
        for i in (1..=n).rev() {
            let take = std::cmp::min(k, backet[i]);
            backet[i] -= take;
            backet[i - 1] += take;
            k -= take;
            if k == 0 {
                break;
            }
        }

        backet
            .iter()
            .enumerate()
            .map(|(i, count)| i * i * count)
            .sum::<usize>() as i64
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let nums1 = [1, 2, 3, 4];
        let nums2 = [2, 10, 20, 19];
        let k1 = 0;
        let k2 = 0;
        let output = 579;
        assert_eq!(
            Solution::min_sum_square_diff(nums1.to_vec(), nums2.to_vec(), k1, k2),
            output
        );
    }

    #[test]
    fn example2() {
        let nums1 = [1, 4, 10, 12];
        let nums2 = [5, 8, 6, 9];
        let k1 = 1;
        let k2 = 1;
        let output = 43;
        assert_eq!(
            Solution::min_sum_square_diff(nums1.to_vec(), nums2.to_vec(), k1, k2),
            output
        );
    }
}
