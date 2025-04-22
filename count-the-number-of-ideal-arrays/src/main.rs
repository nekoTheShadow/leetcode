use std::collections::HashMap;

impl Solution {
    pub fn ideal_arrays(n: i32, max_value: i32) -> i32 {
        let n = n as i128;
        let max_value = max_value as i128;
        let ncr = NCR::new(n * 2);

        (1..=max_value).fold(0, |sum, x| {
            let way = factorize(x)
                .values()
                .fold(1, |acc, e| (acc * ncr.run(n + e - 1, *e)) % MOD);
            (sum + way) % MOD
        }) as i32
    }
}

const MOD: i128 = 1_000_000_000 + 7;

fn factorize(n: i128) -> HashMap<i128, i128> {
    let mut m = n;
    let mut p = 2;
    let mut h = HashMap::new();

    while p * p <= n {
        while m % p == 0 {
            *h.entry(p).or_insert(0) += 1;
            m /= p;
        }
        p += 1;
    }

    if m > 1 {
        *h.entry(m).or_insert(0) += 1;
    }

    h
}

fn modinv(a: i128) -> i128 {
    modpow(a, MOD - 2)
}

fn modpow(base: i128, exp: i128) -> i128 {
    if exp == 0 {
        return 1;
    }
    if exp % 2 == 0 {
        modpow((base * base) % MOD, exp / 2)
    } else {
        (modpow(base, exp - 1) * base) % MOD
    }
}

struct NCR {
    f: Vec<i128>,
    g: Vec<i128>,
}

impl NCR {
    fn new(n: i128) -> Self {
        let n = n as usize;
        let mut f = vec![1_i128; n + 1];
        let mut g = vec![1_i128; n + 1];
        for i in 2..=n {
            f[i] = f[i - 1] * (i as i128) % MOD;
            g[i] = modinv(f[i]);
        }
        Self { f, g }
    }

    fn run(&self, n: i128, r: i128) -> i128 {
        let n = n as usize;
        let r = r as usize;
        self.f[n] * (self.g[r] * self.g[n - r] % MOD) % MOD
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::ideal_arrays(2, 5), 10);
    assert_eq!(Solution::ideal_arrays(5, 3), 11);
    assert_eq!(Solution::ideal_arrays(5878, 2900), 465040898);
}
