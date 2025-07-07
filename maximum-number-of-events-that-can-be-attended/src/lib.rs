use std::{
    cmp::Reverse,
    collections::{BinaryHeap, VecDeque},
};

use itertools::Itertools;

impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        let mut events = events
            .iter()
            .map(|event| (event[0], event[1]))
            .sorted_unstable_by_key(|&(start_day, end_day)| (start_day, Reverse(end_day)))
            .collect::<VecDeque<_>>();

        let mut min_heap = BinaryHeap::new();
        let mut count = 0;

        let last_day = *events
            .iter()
            .map(|(_start_day, end_day)| end_day)
            .max()
            .unwrap();
        for day in 1..=last_day {
            // その日に始まるイベントをヒープに追加
            while let Some(&(start_day, end_day)) = events.front() {
                if start_day == day {
                    min_heap.push(Reverse(end_day));
                    events.pop_front();
                } else {
                    break;
                }
            }

            // すでに終了しているイベントを削除
            while let Some(Reverse(end_day)) = min_heap.peek() {
                if end_day < &day {
                    min_heap.pop();
                } else {
                    break;
                }
            }

            // 今日参加できるイベントがあれば1つ参加
            if let Some(Reverse(_)) = min_heap.pop() {
                count += 1;
            }
        }

        count
    }
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let events = [[1, 2], [2, 3], [3, 4]]
            .map(|event| event.to_vec())
            .to_vec();
        assert_eq!(Solution::max_events(events), 3)
    }

    #[test]
    fn example2() {
        let events = [[1, 2], [2, 3], [3, 4], [1, 2]]
            .map(|event| event.to_vec())
            .to_vec();
        assert_eq!(Solution::max_events(events), 4)
    }
}
