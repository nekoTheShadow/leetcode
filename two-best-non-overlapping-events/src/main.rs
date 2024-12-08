use std::{cmp::Reverse, collections::BinaryHeap};

impl Solution {
    pub fn max_two_events(events: Vec<Vec<i32>>) -> i32 {
        let mut events = events;
        events.sort_unstable_by_key(|event| event[0]);

        let mut max_val = 0;
        let mut max_sum = 0;

        let mut pq = BinaryHeap::new();
        for event in events {
            while let Some(&(Reverse(e), v)) = pq.peek() {
                if e < event[0] {
                    max_val = std::cmp::max(max_val, v);
                    pq.pop();
                } else {
                    break;
                }
            }

            max_sum = std::cmp::max(max_sum, max_val + event[2]);
            pq.push((Reverse(event[1]), event[2]));
        }

        max_sum
    }
}

struct Solution;

fn main() {
    check(&[[1, 3, 2], [4, 5, 2], [2, 4, 3]], 4);
    check(&[[1, 3, 2], [4, 5, 2], [1, 5, 5]], 5);
    check(&[[1, 5, 3], [1, 5, 1], [6, 6, 5]], 8);
    check(
        &[[10, 83, 53], [63, 87, 45], [97, 100, 32], [51, 61, 16]],
        85,
    );
}

fn check(events: &[[i32; 3]], expected: i32) {
    assert_eq!(
        expected,
        Solution::max_two_events(
            events
                .iter()
                .map(|event| event.to_vec())
                .collect::<Vec<_>>()
        )
    )
}
