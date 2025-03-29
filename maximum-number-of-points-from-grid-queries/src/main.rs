use std::{
    cmp::Reverse,
    collections::{BinaryHeap, HashSet},
};

impl Solution {
    pub fn max_points(grid: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        let n = queries.len();
        let h = grid.len() as i32;
        let w = grid[0].len() as i32;

        let mut sorted_queries = (0..n).map(|i| (i, queries[i])).collect::<Vec<_>>();
        sorted_queries.sort_by_key(|(_i, query)| *query);
        let mut ans = vec![0; n];
        let mut visited = HashSet::new();
        let mut pq = BinaryHeap::new();
        pq.push((Reverse(grid[0][0]), 0, 0));

        for (i, query) in sorted_queries {
            while let Some(&(Reverse(v), x, y)) = pq.peek() {
                if v >= query {
                    break;
                }

                pq.pop();
                if visited.contains(&(x, y)) {
                    continue;
                }
                visited.insert((x, y));
                for (dx, dy) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                    let nx = x + dx;
                    let ny = y + dy;
                    if 0 <= nx && nx < h && 0 <= ny && ny < w && !visited.contains(&(nx, ny)) {
                        pq.push((Reverse(grid[nx as usize][ny as usize]), nx, ny));
                    }
                }
            }

            ans[i] = visited.len() as i32;
        }
        ans
    }
}

struct Solution;

fn main() {
    testing!([[1, 2, 3], [2, 5, 7], [3, 5, 1]], [5, 6, 2], [5, 8, 1]);
    testing!([[5, 2, 1], [1, 1, 2]], [3], [0]);
}

#[macro_export]
macro_rules! testing {
    ($grid:expr, $queries:expr, $expected:expr) => {
        let actual =
            Solution::max_points($grid.map(|row| row.to_vec()).to_vec(), $queries.to_vec());
        assert_eq!(actual, $expected.to_vec())
    };
}
