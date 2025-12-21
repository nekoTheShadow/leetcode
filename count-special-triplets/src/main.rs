use std::collections::HashMap;

const MOD: i128 = 1_000_000_000 + 7;

impl Solution {
    pub fn special_triplets(nums: Vec<i32>) -> i32 {
        let mut l = HashMap::new();
        let mut r = HashMap::new();

        inc(&mut l, nums[0]);
        for num in &nums[2..] {
            inc(&mut r, *num);
        }


        let mut total = 0;
        for i in 1..nums.len() - 1 {
            total += (get(&l, nums[i] * 2) * get(&r, nums[i] * 2)) % MOD;
            total %= MOD;

            inc(&mut l, nums[i]);
            dec(&mut r, nums[i + 1]);
        }

        total as i32
    }
}

fn inc(dict: &mut HashMap<i32, i128>, key: i32) {
    *dict.entry(key).or_insert(0) += 1;
}

fn dec(dict: &mut HashMap<i32, i128>, key: i32) {
    *dict.entry(key).or_insert(0) -= 1;
}

fn get(dict: &HashMap<i32, i128>, key: i32) -> i128 {
    *dict.get(&key).unwrap_or(&0)
}

struct Solution;

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let nums = [6, 3, 6];
        let output = 1;
        assert_eq!(Solution::special_triplets(nums.to_vec()), output)
    }

    #[test]
    fn example2() {
        let nums = [0, 1, 0, 0];
        let output = 1;
        assert_eq!(Solution::special_triplets(nums.to_vec()), output)
    }

    #[test]
    fn example3() {
        let nums = [8, 4, 2, 8, 4];
        let output = 2;
        assert_eq!(Solution::special_triplets(nums.to_vec()), output)
    }
}

fn main() {
    println!("Hello, world!");
}
