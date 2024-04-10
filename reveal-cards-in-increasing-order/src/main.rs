use std::collections::VecDeque;

impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        let n = deck.len();
        let mut q = (0..n).collect::<VecDeque<_>>();
        let mut a = Vec::new();
        loop {
            a.push(q.pop_front().unwrap());
            if let Some(v) = q.pop_front() {
                q.push_back(v);
            } else {
                break;
            }
        }

        let mut deck = deck;
        deck.sort();
        let mut b = a.iter().zip(deck).collect::<Vec<_>>();
        b.sort_by_key(|(i, v)| **i);
        b.iter().map(|(i, v)| *v).collect::<Vec<_>>()
    }
}

struct Solution;

fn main() {
    println!(
        "{:?}",
        Solution::deck_revealed_increasing(vec![17, 13, 11, 2, 3, 5, 7])
    );
    println!("{:?}", Solution::deck_revealed_increasing(vec![1, 1000]));
}
