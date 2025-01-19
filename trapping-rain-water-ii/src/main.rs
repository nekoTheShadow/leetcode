use std::{cmp::Reverse, collections::BinaryHeap};

impl Solution {
    pub fn trap_rain_water(height_map: Vec<Vec<i32>>) -> i32 {
        let h = height_map.len() as i32;
        let w = height_map[0].len() as i32;

        let mut visited = vec![vec![false; w as usize]; h as usize];
        let mut pq = BinaryHeap::new();
        for i in 0..h {
            pq.push((Reverse(get!(height_map, i, 0)), i, 0));
            pq.push((Reverse(get!(height_map, i, w - 1)), i, w - 1));
            get!(visited, i, 0) = true;
            get!(visited, i, w - 1) = true;
        }
        for j in 0..w {
            pq.push((Reverse(get!(height_map, 0, j)), 0, j));
            pq.push((Reverse(get!(height_map, h - 1, j)), h - 1, j));
            get!(visited, 0, j) = true;
            get!(visited, h - 1, j) = true;
        }

        let mut max_val = 0;
        let mut capacity = 0;
        while let Some((Reverse(v), x, y)) = pq.pop() {
            capacity += std::cmp::max(0, max_val - v);
            max_val = std::cmp::max(max_val, v);
            for (p, q) in [(x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)] {
                if 0 <= p && p < h && 0 <= q && q < w && !get!(visited, p, q) {
                    get!(visited, p, q) = true;
                    pq.push((Reverse(get!(height_map, p, q)), p, q));
                }
            }
        }
        capacity
    }
}

#[macro_export]
macro_rules! get {
    ($matrix:expr,$x:expr, $y:expr) => {
        $matrix[$x as usize][$y as usize]
    };
}

struct Solution;

fn main() {
    testing!(
        [[1, 4, 3, 1, 3, 2], [3, 2, 1, 3, 2, 4], [2, 3, 3, 2, 3, 1]],
        4
    );
    testing!(
        [
            [3, 3, 3, 3, 3],
            [3, 2, 2, 2, 3],
            [3, 2, 1, 2, 3],
            [3, 2, 2, 2, 3],
            [3, 3, 3, 3, 3]
        ],
        10
    );
}

#[macro_export]
macro_rules! testing {
    ($height_map:expr, $expected:expr) => {
        let actual =
            Solution::trap_rain_water($height_map.into_iter().map(|a| a.to_vec()).collect());
        assert_eq!($expected, actual)
    };
}
