impl Solution {
    pub fn find_the_city(n: i32, edges: Vec<Vec<i32>>, distance_threshold: i32) -> i32 {
        let n = n as usize;
        let inf = i32::MAX / 2 - 1;
        let mut d = vec![vec![inf; n]; n];
        for edge in edges {
            let from = edge[0] as usize;
            let to = edge[1] as usize;
            let weight = edge[2];
            d[from][to] = weight;
            d[to][from] = weight;
        }
        for i in 0..n {
            d[i][i] = 0;
        }

        for k in 0..n {
            for i in 0..n {
                for j in 0..n {
                    d[i][j] = std::cmp::min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        (0..n)
            .rev()
            .min_by_key(|x| d[*x].iter().filter(|v| **v <= distance_threshold).count())
            .unwrap() as i32
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::find_the_city(
            4,
            [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]]
                .map(|a| a.to_vec())
                .to_vec(),
            4
        )
    );
    println!(
        "{}",
        Solution::find_the_city(
            5,
            [
                [0, 1, 2],
                [0, 4, 8],
                [1, 2, 3],
                [1, 4, 2],
                [2, 3, 1],
                [3, 4, 1]
            ]
            .map(|a| a.to_vec())
            .to_vec(),
            2
        )
    );
}
