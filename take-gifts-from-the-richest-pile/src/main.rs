use std::collections::BinaryHeap;

impl Solution {
    pub fn pick_gifts(gifts: Vec<i32>, k: i32) -> i64 {
        let mut pq = gifts.into_iter().map(i64::from).collect::<BinaryHeap<_>>();
        for _ in 0..k {
            let v = pq.pop().unwrap();
            pq.push(sqrt(v));
        }
        pq.iter().sum()
    }
}

fn sqrt(x: i64) -> i64 {
    let mut ok = 0;
    let mut ng = x + 1;
    while (ok - ng).abs() > 1 {
        let mi = (ok + ng) / 2;
        if mi * mi <= x {
            ok = mi;
        } else {
            ng = mi;
        }
    }
    ok
}

struct Solution;

fn main() {
    assert_eq!(Solution::pick_gifts(vec![25, 64, 9, 4, 100], 4), 29);
    assert_eq!(Solution::pick_gifts(vec![1, 1, 1, 1], 4), 4);
}
