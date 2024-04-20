use std::collections::VecDeque;

impl Solution {
    pub fn find_farmland(land: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut land = land;
        let m = land.len() as i32;
        let n = land[0].len() as i32;

        let mut ret = Vec::new();
        for x in 0..m {
            for y in 0..n {
                if land[x as usize][y as usize] == 0 {
                    continue;
                }

                let mut stack = VecDeque::new();
                stack.push_back((x, y));
                let mut i0 = i32::MAX;
                let mut j0 = i32::MAX;
                let mut i1 = i32::MIN;
                let mut j1 = i32::MIN;
                while !stack.is_empty() {
                    let (i, j) = stack.pop_back().unwrap();
                    land[i as usize][j as usize] = 0;
                    i0 = i0.min(i);
                    j0 = j0.min(j);
                    i1 = i1.max(i);
                    j1 = j1.max(j);

                    for (di, dj) in [(1, 0), (-1, 0), (0, 1), (0, -1)] {
                        let ni = i + di;
                        let nj = j + dj;
                        if 0 <= ni
                            && ni < m
                            && 0 <= nj
                            && nj < n
                            && land[ni as usize][nj as usize] == 1
                        {
                            stack.push_back((ni, nj))
                        }
                    }
                }
                ret.push(vec![i0, j0, i1, j1])
            }
        }

        ret
    }
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let actual = Solution::find_farmland(
            [[1, 0, 0], [0, 1, 1], [0, 1, 1]]
                .map(|row| row.to_vec())
                .to_vec(),
        );
        let expected = [[0, 0, 0, 0], [1, 1, 2, 2]]
            .map(|row| row.to_vec())
            .to_vec();
        assert_eq!(actual, expected)
    }

    #[test]
    fn example2() {
        let actual = Solution::find_farmland([[1, 1], [1, 1]].map(|row| row.to_vec()).to_vec());
        let expected = [[0, 0, 1, 1]].map(|row| row.to_vec()).to_vec();
        assert_eq!(actual, expected)
    }

    #[test]
    fn example3() {
        let actual = Solution::find_farmland([[0]].map(|row| row.to_vec()).to_vec());
        assert!(actual.is_empty())
    }
}
