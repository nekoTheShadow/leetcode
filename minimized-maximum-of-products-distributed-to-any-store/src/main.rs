impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        let mut ok = quantities.iter().max().unwrap() + 1;
        let mut ng = 0;
        while (ok - ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if quantities
                .iter()
                .map(|&quantity| div_ceil(quantity, mi))
                .sum::<i32>()
                <= n
            {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        ok
    }
}

fn div_ceil(x: i32, y: i32) -> i32 {
    if x % y == 0 {
        x / y
    } else {
        x / y + 1
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::minimized_maximum(6, vec![11, 6]), 3);
    assert_eq!(Solution::minimized_maximum(7, vec![15, 10, 10]), 5);
}
