use std::collections::VecDeque;


impl Solution {
    pub fn open_lock(deadends: Vec<String>, target: String) -> i32 {
        let target = target.parse::<usize>().unwrap();
        let mut is_dead = vec![false; 9999+1];
        for deadend in &deadends {
            is_dead[deadend.parse::<usize>().unwrap()] = true;
        }

        let mut queue = VecDeque::new();
        queue.push_back(0_usize);

        let mut memo = vec![i32::MAX / 2; 9999+1];
        memo[0] = 0;

        while let Some(s) = queue.pop_front() {
            if is_dead[s] {
                continue;
            }
            if s == target {
                return memo[s];
            }

            for i in 0..4 {
                let a = s % 10_usize.pow(i+1) / 10_usize.pow(i);
                let b1 = if a == 9 { 0 } else { a + 1 };
                let b2 = if a == 0 { 9 } else { a - 1 };
                let t1 = s - (a * 10_usize.pow(i)) + (b1 * 10_usize.pow(i));
                let t2 = s - (a * 10_usize.pow(i)) + (b2 * 10_usize.pow(i));

                if memo[s] + 1 < memo[t1] {
                    memo[t1] = memo[s] + 1;
                    queue.push_back(t1);
                }
                if memo[s] + 1 < memo[t2] {
                    memo[t2] = memo[s] + 1;
                    queue.push_back(t2);
                }
            }
        }

        -1
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::open_lock(["0201","0101","0102","1212","2002"].map(|v| v.to_string()).to_vec(), String::from("0202")));
    println!("{}", Solution::open_lock(["8888"].map(|v| v.to_string()).to_vec(), String::from("0009")));
    println!("{}", Solution::open_lock(["8887","8889","8878","8898","8788","8988","7888","9888"].map(|v| v.to_string()).to_vec(), String::from("8888")));
}
