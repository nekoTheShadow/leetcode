struct Solution;

impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        let primes = eratosthenes(1001);

        let mut nums = nums;
        if let Some(v) = lower_bound(&primes, nums[0]) {
            nums[0] -= v;
        }
        for i in 1..nums.len() {
            if let Some(v) = lower_bound(&primes, nums[i] - nums[i - 1]) {
                nums[i] -= v;
            }
            if nums[i - 1] >= nums[i] {
                return false;
            }
        }

        true
    }
}

fn eratosthenes(n: usize) -> Vec<i32> {
    let mut is_prime = vec![true; n];
    is_prime[0] = false;
    is_prime[1] = false;
    let mut primes = Vec::new();

    for i in 0..n {
        if !is_prime[i] {
            continue;
        }
        primes.push(i as i32);
        for j in (i * i..n).step_by(i) {
            is_prime[j] = false;
        }
    }
    primes
}

fn lower_bound(primes: &[i32], x: i32) -> Option<i32> {
    match primes.binary_search(&x) {
        Ok(i) => {
            if i == 0 {
                None
            } else {
                Some(primes[i - 1])
            }
        }
        Err(i) => {
            if i == 0 {
                None
            } else {
                Some(primes[i - 1])
            }
        }
    }
}

fn main() {
    println!("{:?}", Solution::prime_sub_operation(vec![4, 9, 6, 10]));
    println!("{:?}", Solution::prime_sub_operation(vec![6, 8, 11, 12]));
    println!("{:?}", Solution::prime_sub_operation(vec![5, 8, 3]));
}
