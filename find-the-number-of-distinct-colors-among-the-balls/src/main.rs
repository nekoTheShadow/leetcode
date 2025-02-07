use std::collections::HashMap;

impl Solution {
    pub fn query_results(limit: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let mut colors = HashMap::new();
        let mut counter = HashMap::new();

        let mut answers = Vec::new();
        for query in queries {
            let ball = query[0];
            let new_color = query[1];
            
            if let Some(&current_color) = colors.get(&ball) {
                counter.insert(current_color, counter[&current_color] - 1);
                if counter[&current_color] == 0 {
                    counter.remove(&current_color);
                }
            }
            colors.insert(ball, new_color);
            *counter.entry(new_color).or_insert(0) += 1;

            answers.push(counter.len() as i32);
        }

        answers
    }
}

struct Solution;

fn main() {
    testing(4, &[[1, 4], [2, 5], [1, 3], [3, 4]], &[1, 2, 2, 3]);
    testing(
        4,
        &[[0, 1], [1, 2], [2, 2], [3, 4], [4, 5]],
        &[1, 2, 2, 3, 4],
    );
}

fn testing(limit: i32, queries: &[[i32; 2]], expected: &[i32]) {
    let actual =
        Solution::query_results(limit, queries.iter().map(|query| query.to_vec()).collect());
    assert_eq!(expected.to_vec(), actual);
}
