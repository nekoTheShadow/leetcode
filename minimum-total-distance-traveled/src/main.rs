use std::collections::HashMap;

impl Solution {
    pub fn minimum_total_distance(robot: Vec<i32>, factory: Vec<Vec<i32>>) -> i64 {
        let mut robots = robot.iter().map(|r| *r as i64).collect::<Vec<_>>();
        let mut factories = factory
            .iter()
            .flat_map(|f| vec![f[0] as i64; f[1] as usize])
            .collect::<Vec<_>>();

        robots.sort();
        factories.sort();

        Self::dfs(&mut HashMap::new(), &robots, &factories, 0, 0)
    }

    pub fn dfs(
        memo: &mut HashMap<(usize, usize), i64>,
        robots: &Vec<i64>,
        factories: &Vec<i64>,
        ri: usize,
        fi: usize,
    ) -> i64 {
        if robots.len() == ri {
            return 0;
        }
        if factories.len() == fi {
            return i64::MAX / 2 - 1;
        }
        if let Some(v) = memo.get(&(ri, fi)) {
            return *v;
        }

        let v1 =
            (robots[ri] - factories[fi]).abs() + Self::dfs(memo, robots, factories, ri + 1, fi + 1);
        let v2 = Self::dfs(memo, robots, factories, ri, fi + 1);
        memo.insert((ri, fi), std::cmp::min(v1, v2));
        memo[&(ri, fi)]
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::minimum_total_distance(
            vec![0, 4, 6],
            [[2, 2], [6, 2]].map(|r| r.to_vec()).to_vec()
        )
    );
    println!(
        "{}",
        Solution::minimum_total_distance(
            vec![1, -1],
            [[-2, 1], [2, 1]].map(|r| r.to_vec()).to_vec()
        )
    );
}
