use std::collections::{HashMap, hash_map::Entry::Occupied};

use itertools::Itertools;

impl Solution {
    pub fn count_servers(n: i32, logs: Vec<Vec<i32>>, x: i32, queries: Vec<i32>) -> Vec<i32> {
        let logs = logs
            .iter()
            .map(|log| (log[0], log[1]))
            .sorted_unstable_by_key(|&(_server, time)| time)
            .collect::<Vec<_>>();
        let mut answer = vec![0; queries.len()];
        let mut left = 0;
        let mut right = 0;
        let mut active = HashMap::new();
        for (index, &query) in queries
            .iter()
            .enumerate()
            .sorted_unstable_by_key(|(_index, query)| **query)
        {
            while let Some(&(server, time)) = logs.get(right)
                && time <= query
            {
                *active.entry(server).or_insert(0) += 1;
                right += 1;
            }
            while let Some(&(server, time)) = logs.get(left)
                && time < query - x
            {
                if active[&server] == 1 {
                    active.remove(&server);
                } else {
                    active.insert(server, active[&server] - 1);
                }
                left += 1;
            }
            answer[index] = n - (active.len() as i32);
        }
        answer
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let n = 3;
        let logs = [[1, 3], [2, 6], [1, 5]];
        let x = 5;
        let queries = [10, 11];
        let output = [1, 2];
        assert_eq!(
            Solution::count_servers(
                n,
                logs.map(|log| log.to_vec()).to_vec(),
                x,
                queries.to_vec()
            ),
            output.to_vec()
        );
    }

    #[test]
    fn example2() {
        let n = 3;
        let logs = [[2, 4], [2, 1], [1, 2], [3, 1]];
        let x = 2;
        let queries = [3, 4];
        let output = [0, 1];
        assert_eq!(
            Solution::count_servers(
                n,
                logs.map(|log| log.to_vec()).to_vec(),
                x,
                queries.to_vec()
            ),
            output.to_vec()
        );
    }
}
