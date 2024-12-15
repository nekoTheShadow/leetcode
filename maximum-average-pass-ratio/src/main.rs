use std::collections::BinaryHeap;

#[derive(PartialEq, PartialOrd, Debug)]
struct Float {
    v: f64,
}

impl Float {
    fn new(v: f64) -> Self {
        Self { v }
    }
}

impl Eq for Float {}

impl Ord for Float {
    fn cmp(&self, other: &Self) -> std::cmp::Ordering {
        self.partial_cmp(other).unwrap()
    }
}

impl Solution {
    pub fn max_average_ratio(classes: Vec<Vec<i32>>, extra_students: i32) -> f64 {
        let mut pq = BinaryHeap::new();
        for class in &classes {
            let pass = class[0];
            let total = class[1];
            pq.push((calc_gain(pass, total), pass, total));
        }

        for _ in 0..extra_students {
            let (_, pass, total) = pq.pop().unwrap();
            pq.push((calc_gain(pass + 1, total + 1), pass + 1, total + 1));
        }

        let sum = pq
            .iter()
            .map(|&(_, pass, total)| calc_ratio(pass, total))
            .sum::<f64>();
        sum / (classes.len() as f64)
    }
}

fn calc_gain(pass: i32, total: i32) -> Float {
    Float::new(calc_ratio(pass + 1, total + 1) - calc_ratio(pass, total))
}

fn calc_ratio(pass: i32, total: i32) -> f64 {
    (pass as f64) / (total as f64)
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::max_average_ratio([[1, 2], [3, 5], [2, 2]].map(|a| a.to_vec()).to_vec(), 2)
    );
    println!(
        "{}",
        Solution::max_average_ratio(
            [[2, 4], [3, 9], [4, 5], [2, 10]]
                .map(|a| a.to_vec())
                .to_vec(),
            4
        )
    );
}
