use std::{cmp::max, collections::HashMap};

impl Solution {
    pub fn maximum_length(nums: Vec<i32>) -> i32 {
        let mut counter = HashMap::new();
        for &num in &nums {
            *counter.entry(num).or_insert(0) += 1;
        }

        // 1は特別扱いする
        let size1 = counter
            .get(&1)
            .map(|&v| if v % 2 == 0 { v - 1 } else { v })
            .unwrap_or(0);
        counter.remove(&1);

        let mut max_size = size1;
        for &key in counter.keys() {
            let mut x = key;
            let mut size = 0;

            while let Some(&count) = counter.get(&x) {
                if count == 1 {
                    size += 1;
                    break;
                } else {
                    size += 2;
                    x *= x;
                }
            }
            if size % 2 == 0 {
                size -= 1;
            }
            max_size = max(max_size, size);
        }

        max_size
    }
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
        assert_eq!(Solution::maximum_length(vec![5, 4, 1, 2, 2]), 3);
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::maximum_length(vec![1, 3, 2, 4]), 1);
    }
}
