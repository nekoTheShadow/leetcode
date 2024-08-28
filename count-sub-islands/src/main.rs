impl Solution {
    pub fn count_sub_islands(grid1: Vec<Vec<i32>>, grid2: Vec<Vec<i32>>) -> i32 {
        let mut grid2 = grid2;
        let m = grid1.len();
        let n = grid1[0].len();

        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if grid2[i][j] == 0 {
                    continue;
                }

                let mut stack = vec![(i, j)];
                let mut ok = true;
                while let Some((x, y)) = stack.pop() {
                    grid2[x][y] = 0;
                    if grid1[x][y] == 0 {
                        ok = false;
                    }
                    for (dx, dy) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
                        let p = x as i32 + dx;
                        let q = y as i32 + dy;
                        if 0 <= p
                            && (p < m as i32)
                            && 0 <= q
                            && (q < n as i32)
                            && grid2[p as usize][q as usize] == 1
                        {
                            stack.push((p as usize, q as usize));
                        }
                    }
                }

                if ok {
                    count += 1;
                }
            }
        }

        count
    }
}

struct Solution;

fn main() {
    example1();
    example2();
}

fn example1() {
    let grid1 = [
        [1, 1, 1, 0, 0],
        [0, 1, 1, 1, 1],
        [0, 0, 0, 0, 0],
        [1, 0, 0, 0, 0],
        [1, 1, 0, 1, 1],
    ]
    .map(|a| a.to_vec())
    .to_vec();
    let grid2 = [
        [1, 1, 1, 0, 0],
        [0, 0, 1, 1, 1],
        [0, 1, 0, 0, 0],
        [1, 0, 1, 1, 0],
        [0, 1, 0, 1, 0],
    ]
    .map(|a| a.to_vec())
    .to_vec();
    println!("{}", Solution::count_sub_islands(grid1, grid2));
}

fn example2() {
    let grid1 = [
        [1, 0, 1, 0, 1],
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1],
        [1, 0, 1, 0, 1],
    ]
    .map(|a| a.to_vec())
    .to_vec();
    let grid2 = [
        [0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1],
        [0, 1, 0, 1, 0],
        [0, 1, 0, 1, 0],
        [1, 0, 0, 0, 1],
    ]
    .map(|a| a.to_vec())
    .to_vec();
    println!("{}", Solution::count_sub_islands(grid1, grid2));
}
