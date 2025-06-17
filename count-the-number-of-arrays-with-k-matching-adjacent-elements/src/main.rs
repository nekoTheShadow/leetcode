const MOD: i128 = 1_000_000_000 + 7;

#[macro_export]
macro_rules! product {
    ($( $x:expr ),* ) => {{
        1 $( * $x % MOD)+
    }};
}

fn modinv(a: i128) -> i128 {
    modpow(a, MOD - 2)
}

fn modpow(base: i128, exp: i128) -> i128 {
    if exp == 0 {
        return 1;
    }
    if exp % 2 == 0 {
        modpow(product!(base, base), exp / 2)
    } else {
        product!(modpow(base, exp - 1), base)
    }
}

fn ncr(n: i128, r: i128) -> i128 {
    let mut f = vec![1_i128; (n + 1) as usize];
    for i in 2..=n {
        f[i as usize] = product!(f[(i - 1) as usize], i);
    }
    product!(
        f[n as usize],
        modinv(f[r as usize]),
        modinv(f[(n - r) as usize])
    )
}

impl Solution {
    pub fn count_good_arrays(n: i32, m: i32, k: i32) -> i32 {
        let n = n as i128;
        let m = m as i128;
        let k = k as i128;
        product!(ncr(n - 1, k), m, modpow(m - 1, n - k - 1)) as i32
    }
}
struct Solution;

fn main() {
    assert_eq!(Solution::count_good_arrays(3, 2, 1), 4);
    assert_eq!(Solution::count_good_arrays(4, 2, 2), 6);
    assert_eq!(Solution::count_good_arrays(5, 2, 0), 2);

    assert_eq!(Solution::count_good_arrays(87658, 52720, 44235), 427761120);
    assert_eq!(Solution::count_good_arrays(98247, 98246, 60004), 817857772);
}
