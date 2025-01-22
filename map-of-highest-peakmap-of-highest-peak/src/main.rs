use std::collections::VecDeque;

const INF: i32 = 1_000_000_000;

impl Solution {
    pub fn highest_peak(is_water: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let h = is_water.len() as i32;
        let w = is_water[0].len() as i32;

        let mut heights = vec![vec![INF; w as usize]; h as usize];
        let mut q = VecDeque::new();
        for i in 0..h {
            for j in 0..w {
                if get!(is_water, i, j) == 1 {
                    q.push_back((i, j));
                    get!(heights, i, j) = 0;
                }
            }
        }

        while let Some((cur_i, cur_j)) = q.pop_front() {
            for (di, dj) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let nxt_i = cur_i + di;
                let nxt_j = cur_j + dj;
                if (0..h).contains(&nxt_i)
                    && (0..w).contains(&nxt_j)
                    && get!(heights, cur_i, cur_j) + 1 < get!(heights, nxt_i, nxt_j)
                {
                    get!(heights, nxt_i, nxt_j) = get!(heights, cur_i, cur_j) + 1;
                    q.push_back((nxt_i, nxt_j));
                }
            }
        }

        heights
    }
}

#[macro_export]
macro_rules! get {
    ($matrix:expr, $i:expr, $j:expr) => {
        $matrix[$i as usize][$j as usize]
    };
}

struct Solution;

fn main() {
    testing!("Example1", [[0, 1], [0, 0]]);
    testing!("Example2", [[0, 0, 1], [1, 0, 0], [0, 0, 0]]);
}

#[macro_export]
macro_rules! testing {
    ($name:expr, $is_water:expr) => {
        println!("{}:", $name);
        for row in Solution::highest_peak($is_water.map(|r| r.to_vec()).to_vec()) {
            println!("  {:?}", row);
        }
    };
}
