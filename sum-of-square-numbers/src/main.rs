use std::collections::HashSet;

impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        let c = c as i128;
        let mut set = HashSet::new();

        for a in 0.. {
            let aa = a * a;
            let bb = c - aa;
            if bb < 0 {
                break;
            }

            set.insert(aa);
            if set.contains(&bb) {
                return true;
            }
        }

        false
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::judge_square_sum(5));
    println!("{}", Solution::judge_square_sum(3));
    println!("{}", Solution::judge_square_sum(100000));
}
