impl Solution {
    pub fn check_if_prerequisite(
        num_courses: i32,
        prerequisites: Vec<Vec<i32>>,
        queries: Vec<Vec<i32>>,
    ) -> Vec<bool> {
        let n = num_courses as usize;

        let mut d = vec![vec![false; n]; n];
        for prerequisite in prerequisites {
            let u = prerequisite[0] as usize;
            let v = prerequisite[1] as usize;
            d[u][v] = true;
        }
        for k in 0..n {
            for i in 0..n {
                for j in 0..n {
                    d[i][j] = d[i][j] || (d[i][k] && d[k][j]);
                }
            }
        }

        queries
            .iter()
            .map(|query| {
                let a = query[0] as usize;
                let b = query[1] as usize;
                d[a][b]
            })
            .collect()
    }
}

struct Solution;

fn main() {
    testing(2, &[[1, 0]], &[[0, 1], [1, 0]], &[false, true]);
    testing(2, &[], &[[0, 1], [1, 0]], &[false, false]);
    testing(
        3,
        &[[1, 2], [1, 0], [2, 0]],
        &[[1, 0], [1, 2]],
        &[true, true],
    );
    testing(
        4,
        &[[2, 3], [2, 1], [0, 3], [0, 1]],
        &[[0, 1], [0, 3], [2, 3], [3, 0], [2, 0], [0, 2]],
        &[true, true, true, false, false, false],
    );
}

fn testing(num_courses: i32, prerequisites: &[[i32; 2]], queries: &[[i32; 2]], expected: &[bool]) {
    let actual =
        Solution::check_if_prerequisite(num_courses, to_vec(prerequisites), to_vec(queries));
    assert_eq!(expected.to_vec(), actual)
}

fn to_vec(mat: &[[i32; 2]]) -> Vec<Vec<i32>> {
    mat.iter().map(|row| row.to_vec()).collect()
}
