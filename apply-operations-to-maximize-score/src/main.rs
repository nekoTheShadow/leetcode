use std::{
    cmp::{min, Reverse},
    collections::HashSet,
};

const MOD: i128 = 1_000_000_007;

impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        let nums = nums.iter().map(|num| *num as i128).collect::<Vec<_>>();
        let k = k as i128;
        let n = nums.len() as i128;

        let prime_scores = nums
            .iter()
            .map(|&num| get_prime_score(num))
            .collect::<Vec<_>>();

        let mut l = vec![-1; n as usize];
        let mut r = vec![n; n as usize];

        let mut stack = Vec::new();
        for i in (0..n).rev() {
            while !stack.is_empty() && prime_scores[top(&stack)] <= prime_scores[i as usize] {
                l[top(&stack)] = i;
                stack.pop();
            }
            stack.push(i);
        }

        let mut stack = Vec::new();
        for i in 0..n {
            while !stack.is_empty() && prime_scores[top(&stack)] < prime_scores[i as usize] {
                r[top(&stack)] = i;
                stack.pop();
            }
            stack.push(i);
        }

        let mut pq = (0..n).map(|i| (nums[i as usize], i)).collect::<Vec<_>>();
        pq.sort_by_key(|&(num, i)| (Reverse(num), i));

        let mut score = 1_i128;
        let mut k = k;
        for (num, i) in pq {
            let c: i128 = min((i - l[i as usize]) * (r[i as usize] - i), k);
            score = score * pow(num, c) % MOD;
            k -= c;
        }
        score as i32
    }
}

fn get_prime_score(num: i128) -> i128 {
    let mut n = num;
    let mut prime = 2;
    let mut primes = HashSet::new();

    while prime * prime <= num {
        while n % prime == 0 {
            primes.insert(prime);
            n /= prime;
        }
        prime += 1;
    }

    if n > 1 {
        primes.insert(n);
    }

    primes.len() as i128
}

fn pow(x: i128, y: i128) -> i128 {
    if y == 0 {
        return 1;
    }
    if y % 2 == 0 {
        pow(x * x % MOD, y / 2) % MOD
    } else {
        x * pow(x, y - 1) % MOD
    }
}

fn top(stack: &Vec<i128>) -> usize {
    *stack.last().unwrap() as usize
}

struct Solution;

fn main() {
    assert_eq!(Solution::maximum_score(vec![8, 3, 9, 3, 8], 2), 81);
    assert_eq!(
        Solution::maximum_score(vec![19, 12, 14, 6, 10, 18], 3),
        4788
    );
    assert_eq!(
        Solution::maximum_score(vec![3289, 2832, 14858, 22011], 6),
        256720975
    );
}
