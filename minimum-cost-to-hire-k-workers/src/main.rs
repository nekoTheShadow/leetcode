use std::collections::BinaryHeap;

impl Solution {
    pub fn mincost_to_hire_workers(quality: Vec<i32>, wage: Vec<i32>, k: i32) -> f64 {
        let mut cost_perfomaces = (0..quality.len())
            .map(|i| (wage[i] as f64 / quality[i] as f64, i))
            .collect::<Vec<_>>();
        cost_perfomaces.sort_by(|(cost_pefomance1, i1), (cost_pefomance2, i2)| {
            cost_pefomance1.partial_cmp(cost_pefomance2).unwrap()
        });

        let mut heap = BinaryHeap::new();
        let mut quality_sum = 0;
        let mut best = f64::MAX;
        for (cost_perfomance, i) in cost_perfomaces {
            if heap.len() == k as usize - 1 {
                best = best.min(cost_perfomance * (quality[i] as f64 + quality_sum as f64));
                heap.push(quality[i]);
                quality_sum += quality[i];
                quality_sum -= heap.pop().unwrap();
            } else {
                heap.push(quality[i]);
                quality_sum += quality[i];
            }
        }

        best
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::mincost_to_hire_workers(vec![10, 20, 5], vec![70, 50, 30], 2)
    );
    println!(
        "{}",
        Solution::mincost_to_hire_workers(vec![3, 1, 10, 10, 1], vec![4, 8, 2, 2, 7], 3)
    );
}
