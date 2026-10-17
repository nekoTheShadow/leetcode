use std::{collections::HashMap, println};

use itertools::Itertools;

impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        let tpls = nums
            .iter()
            .map(|x| (sum_digits(*x), *x))
            .collect::<Vec<_>>();

        let mut dict = tpls
            .iter()
            .enumerate()
            .map(|(i, tpl)| (*tpl, i))
            .collect::<HashMap<_, _>>();
        let mut swapped_tpls = tpls.clone();
        let mut swap = 0;
        for (i, tpl1) in tpls.into_iter().sorted().enumerate() {
            let tpl2 = swapped_tpls[i];
            let j = dict[&tpl1];
            if tpl1 == tpl2 {
                continue;
            }

            swap += 1;
            swapped_tpls.swap(i, j);
            dict.insert(swapped_tpls[i], i);
            dict.insert(swapped_tpls[j], j);
        }

        swap
    }
}

fn sum_digits(mut x: i32) -> i32 {
    let mut tot = 0;
    while x > 0 {
        tot += x % 10;
        x /= 10;
    }
    tot
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
        let nums = [37, 100];
        let output = 1;
        assert_eq!(Solution::min_swaps(nums.to_vec()), output)
    }

    #[test]
    fn example2() {
        let nums = [22, 14, 33, 7];
        let output = 0;
        assert_eq!(Solution::min_swaps(nums.to_vec()), output)
    }

    #[test]
    fn example3() {
        let nums = [18, 43, 34, 16];
        let output = 2;
        assert_eq!(Solution::min_swaps(nums.to_vec()), output)
    }

    #[test]
    fn example4() {
        let nums = [277993448, 416038674, 616955867, 539372283];
        let output = 3;
        assert_eq!(Solution::min_swaps(nums.to_vec()), output)
    }
}
