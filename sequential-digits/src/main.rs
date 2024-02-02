use std::collections::VecDeque;

fn main() {
    println!("{:?}", Solution::sequential_digits(100, 300));
    println!("{:?}", Solution::sequential_digits(1000, 13000));
}

impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        let mut que = (1..9).collect::<VecDeque<_>>();
        let mut ret = vec![];

        while !que.is_empty() {
            let cur = que.pop_front().unwrap();
            if high < cur {
                continue;
            }

            if low <= cur && cur <= high {
                ret.push(cur);
            }

            let n = cur % 10;
            if n < 9 {
                que.push_back(cur * 10 + n + 1);
            }
        }

        ret
    }
}

struct Solution {}
