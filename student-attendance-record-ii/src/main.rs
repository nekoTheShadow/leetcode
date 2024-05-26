use std::collections::HashMap;

impl Solution {
    pub fn check_record(n: i32) -> i32 {
        Self::f(n, &mut HashMap::new(), 0, 0, 0)
    }

    pub fn f(n: i32, memo: &mut HashMap<(i32, i32, i32), i32>, cur: i32, a: i32, l: i32) -> i32 {
        if a == 2 {
            return 0;
        }
        if l == 3 {
            return 0;
        }
        if n == cur {
            return 1;
        }

        let key = (cur, a, l);
        if let Some(v) = memo.get(&key) {
            return *v;
        }

        let mut v = 0;
        let m = 10_i32.pow(9) + 7;
        v += Self::f(n, memo, cur + 1, a + 1, 0); // A
        v %= m;
        v += Self::f(n, memo, cur + 1, a, l + 1); // L
        v %= m;
        v += Self::f(n, memo, cur + 1, a, 0); // P
        v %= m;

        memo.insert(key, v);
        v
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::check_record(2));
    println!("{}", Solution::check_record(1));
    println!("{}", Solution::check_record(10101));
}
