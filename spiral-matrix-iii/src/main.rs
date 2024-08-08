impl Solution {
    pub fn spiral_matrix_iii(rows: i32, cols: i32, r_start: i32, c_start: i32) -> Vec<Vec<i32>> {
        let mut ret = vec![vec![r_start, c_start]];
        let mut r = r_start;
        let mut c = c_start;
        let mut step = 1;

        while ret.len() < (rows * cols) as usize {
            for _ in 0..step {
                c += 1;
                Self::push(rows, cols, &mut ret, vec![r, c]);
            }
            for _ in 0..step {
                r += 1;
                Self::push(rows, cols, &mut ret, vec![r, c]);
            }
            step += 1;
            for _ in 0..step {
                c -= 1;
                Self::push(rows, cols, &mut ret, vec![r, c]);
            }
            for _ in 0..step {
                r -= 1;
                Self::push(rows, cols, &mut ret, vec![r, c]);
            }
            step += 1;
        }

        ret
    }

    fn push(rows: i32, cols: i32, ret: &mut Vec<Vec<i32>>, v: Vec<i32>) {
        let r = v[0];
        let c = v[1];
        if ret.len() < (rows * cols) as usize && 0 <= r && r < rows && 0 <= c && c < cols {
            ret.push(v);
        }
    }
}

struct Solution;

fn main() {
    println!("{:?}", Solution::spiral_matrix_iii(1, 4, 0, 0));
    println!("{:?}", Solution::spiral_matrix_iii(5, 6, 1, 4));
}
