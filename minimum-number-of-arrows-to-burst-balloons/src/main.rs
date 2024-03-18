use std::collections::VecDeque;

impl Solution {
    pub fn find_min_arrow_shots(points: Vec<Vec<i32>>) -> i32 {
        let mut points = points;
        points.sort();

        let mut stack: VecDeque<Vec<i32>> = VecDeque::new();
        for point in points {
            if let Some(last) = stack.back_mut() {
                if last[1] < point[0] {
                    stack.push_back(point);
                } else {
                    last[1] = last[1].min(point[1]);
                }
            } else {
                stack.push_back(point);
            }
        }
        stack.len() as i32
    }
}

struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::find_min_arrow_shots(
            [[10, 16], [2, 8], [1, 6], [7, 12]]
                .iter()
                .map(|v| v.to_vec())
                .collect()
        )
    );
    println!(
        "{}",
        Solution::find_min_arrow_shots(
            [[1, 2], [3, 4], [5, 6], [7, 8]]
                .iter()
                .map(|v| v.to_vec())
                .collect()
        )
    );
    println!(
        "{}",
        Solution::find_min_arrow_shots(
            [[1, 2], [2, 3], [3, 4], [4, 5]]
                .iter()
                .map(|v| v.to_vec())
                .collect()
        )
    );
}
