impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        let left = left as usize;
        let right = right as usize;

        let mut is_prime = vec![true; right + 1];
        is_prime[0] = false;
        is_prime[1] = false;

        let mut x = 2;
        while x * x <= right {
            if is_prime[x] {
                let mut y = x * 2;
                while y <= right {
                    is_prime[y] = false;
                    y += x;
                }
            }
            x += 1;
        }

        let primes = (left..=right).filter(|&x| is_prime[x]).collect::<Vec<_>>();
        if let Some([p1, p2]) = primes.windows(2).min_by_key(|v| v[1] - v[0]) {
            vec![*p1 as i32, *p2 as i32]
        } else {
            vec![-1, -1]
        }
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::closest_primes(10, 19), vec![11, 13]);
    assert_eq!(Solution::closest_primes(4, 6), vec![-1, -1]);
}
