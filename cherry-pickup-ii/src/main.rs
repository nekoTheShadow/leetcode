use std::{cmp::max, collections::HashMap};

struct  Solution{}

impl Solution {
    pub fn cherry_pickup(grid: Vec<Vec<i32>>) -> i32 {
        Self::g(&grid, &mut HashMap::new(), 0, 0, grid[0].len()-1)
    }

    fn g(grid: &Vec<Vec<i32>>, memo: &mut HashMap<(usize, usize, usize), i32>, x: usize, y0: usize, y1: usize) -> i32{
        if x==grid.len()-1 {
            if y0==y1 {
                return grid[x][y0]
            } else {
                return grid[x][y0] + grid[x][y1]
            }
        }

        if memo.contains_key(&(x, y0, y1)) {
            return *memo.get(&(x, y0, y1)).unwrap();
        }

        let mut mx = 0;
        for dy0 in [0, 1, -1] {
            for dy1 in [0, 1, -1] {
                let ny0 = (y0 as isize) + dy0;
                let ny1 = (y1 as isize) + dy1;
                if !(0<=ny0&&ny0<(grid[0].len() as isize) && 0<=ny1&&ny1<(grid[0].len() as isize)) {
                    continue;
                }

                let ny0 = ny0 as usize;
                let ny1 = ny1 as usize;
                if y0==y1 {
                    mx = max(mx, Self::g(grid, memo, x+1, ny0, ny1) + grid[x][y0]);
                } else {
                    mx = max(mx, Self::g(grid, memo, x+1, ny0, ny1) + grid[x][y0] + grid[x][y1]);
                }
            }
        }

        memo.insert((x, y0, y1), mx);
        mx
    }
}

fn main() {
    println!("{}", Solution::cherry_pickup(vec![vec![3,1,1],vec![2,5,1],vec![1,5,5],vec![2,1,1]]));
    println!("{}", Solution::cherry_pickup(vec![vec![1,0,0,0,0,0,1],vec![2,0,0,0,0,3,0],vec![2,0,9,0,0,0,0],vec![0,3,0,5,4,0,0],vec![1,0,2,3,0,0,6]]));
}