use std::collections::HashSet;

impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        let mut set = HashSet::new();
        let mut count = 0;
        for xs in nums.chunks(3).rev() {
            if !push(&mut set, xs) {
                break;
            }
            count += 1;
        }
        div_ceil(nums.len() as i32, 3) - count
    }
}

fn push(set: &mut HashSet<i32>, xs: &[i32]) -> bool {
    for &x in xs {
        if set.contains(&x) {
            return false;
        }
        set.insert(x);
    }
    true
}

fn div_ceil(x: i32, y: i32) -> i32 {
    if x % y == 0 { x / y } else { x / y + 1 }
}

pub struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        assert_eq!(
            Solution::minimum_operations(vec![1, 2, 3, 4, 2, 3, 3, 5, 7]),
            2
        );
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::minimum_operations(vec![4, 5, 6, 4, 4]), 2);
    }

    #[test]
    fn example3() {
        assert_eq!(Solution::minimum_operations(vec![6, 7, 8, 9]), 0);
    }
}
