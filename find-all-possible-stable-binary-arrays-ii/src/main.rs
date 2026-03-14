const MOD: i32 = 1_000_000_000 + 7;

impl Solution {
    pub fn number_of_stable_arrays(zero: i32, one: i32, limit: i32) -> i32 {
        let zero = zero as usize;
        let one = one as usize;
        let limit = limit as usize;

        let mut g = G {
            limit: limit,
            memo: vec![vec![vec![-1; 2]; one + 1]; zero + 1],
        };

        let mut ret = 0;
        ret += g.dp(zero, one, 0);
        ret %= MOD;
        ret += g.dp(zero, one, 1);
        ret %= MOD;
        ret
    }
}

struct G {
    limit: usize,
    memo: Vec<Vec<Vec<i32>>>,
}

impl G {
    fn dp(&mut self, zero: usize, one: usize, bit: usize) -> i32 {
        if zero == 0 {
            return if bit == 0 || one > self.limit { 0 } else { 1 };
        }
        if one == 0 {
            return if bit == 1 || zero > self.limit { 0 } else { 1 };
        }

        if self.memo[zero][one][bit] != -1 {
            return self.memo[zero][one][bit];
        }

        let mut ret = 0;
        if bit == 0 {
            ret += self.dp(zero - 1, one, 0);
            ret %= MOD;
            ret += self.dp(zero - 1, one, 1);
            ret %= MOD;
            if zero > self.limit {
                ret -= self.dp(zero - self.limit - 1, one, 1);
                ret += MOD;
                ret %= MOD;
            }
        } else {
            ret += self.dp(zero, one - 1, 0);
            ret %= MOD;
            ret += self.dp(zero, one - 1, 1);
            ret %= MOD;
            if one > self.limit {
                ret -= self.dp(zero, one - self.limit - 1, 0);
                ret += MOD;
                ret %= MOD;
            }
        }

        self.memo[zero][one][bit] = ret;
        ret
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
        let zero = 1;
        let one = 1;
        let limit = 2;
        let output = 2;
        assert_eq!(Solution::number_of_stable_arrays(zero, one, limit), output);
    }

    #[test]
    fn example2() {
        let zero = 1;
        let one = 2;
        let limit = 1;
        let output = 1;
        assert_eq!(Solution::number_of_stable_arrays(zero, one, limit), output);
    }

    #[test]
    fn example3() {
        let zero = 3;
        let one = 3;
        let limit = 2;
        let output = 14;
        assert_eq!(Solution::number_of_stable_arrays(zero, one, limit), output);
    }
}
