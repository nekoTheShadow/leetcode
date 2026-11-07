use std::{collections::BTreeSet, println};

impl Solution {
    pub fn find_the_distance_value(arr1: Vec<i32>, arr2: Vec<i32>, d: i32) -> i32 {
        let set = BTreeSet::from_iter(arr2.iter());
        arr1.iter()
            .filter(|&&v| set.range(v - d..v + d + 1).next().is_none())
            .count() as i32
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
        let arr1 = [4, 5, 8];
        let arr2 = [10, 9, 1, 8];
        let d = 2;
        let output = 2;
        assert_eq!(
            Solution::find_the_distance_value(arr1.to_vec(), arr2.to_vec(), d),
            output
        )
    }

    #[test]
    fn example2() {
        let arr1 = [1, 4, 2, 3];
        let arr2 = [-4, -3, 6, 10, 20, 30];
        let d = 3;
        let output = 2;
        assert_eq!(
            Solution::find_the_distance_value(arr1.to_vec(), arr2.to_vec(), d),
            output
        )
    }
    #[test]
    fn example3() {
        let arr1 = [2, 1, 100, 3];
        let arr2 = [-5, -2, 10, -3, 7];
        let d = 6;
        let output = 1;
        assert_eq!(
            Solution::find_the_distance_value(arr1.to_vec(), arr2.to_vec(), d),
            output
        )
    }
}
