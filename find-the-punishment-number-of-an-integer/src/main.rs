use std::collections::HashSet;

impl Solution {
    pub fn punishment_number(n: i32) -> i32 {
        (1..=n)
            .filter(|i| find(i * i).contains(i))
            .map(|i| i * i)
            .sum()
    }
}

fn find(n: i32) -> HashSet<i32> {
    let mut x = 10;
    let mut set = HashSet::new();

    set.insert(n);
    while x <= n {
        for nxt in find(n / x) {
            set.insert(nxt + n % x);
        }
        x *= 10;
    }

    set
}
struct Solution;

fn main() {
    println!("{}", Solution::punishment_number(10));
    println!("{}", Solution::punishment_number(37));
}
