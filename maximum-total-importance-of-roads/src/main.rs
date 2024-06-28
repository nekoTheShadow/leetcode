fn main() {
    println!("{}", Solution::maximum_importance(5, [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]].map(|row| row.to_vec()).to_vec()));
    println!("{}", Solution::maximum_importance(5, [[0,3],[2,4],[1,3]].map(|row| row.to_vec()).to_vec()));
}

impl Solution {
    pub fn maximum_importance(n: i32, roads: Vec<Vec<i32>>) -> i64 {
        let mut d = vec![0; n as usize];
        for road in roads {
            d[road[0] as usize] += 1;
            d[road[1] as usize] += 1;
        }

        d.sort();
        d.iter().enumerate().map(|(importance, count)| (1 + importance as i64) * (*count as i64)).sum()
    }
}

struct Solution;