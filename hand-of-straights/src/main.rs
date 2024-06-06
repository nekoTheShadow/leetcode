use std::collections::BTreeMap;

impl Solution {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        let mut counter = BTreeMap::new();
        for v in hand {
            *counter.entry(v).or_insert(0) += 1;
        }

        while !counter.is_empty() {
            let min = counter.keys().next().unwrap();
            for v in *min..*min + group_size {
                if !counter.contains_key(&v) {
                    return false;
                }

                *counter.get_mut(&v).unwrap() -= 1;
                if counter[&v] == 0 {
                    counter.remove(&v);
                }
            }
        }

        true
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::is_n_straight_hand(vec![1, 2, 3, 6, 2, 3, 4, 7, 8], 3)
    );
    println!("{}", Solution::is_n_straight_hand(vec![1, 2, 3, 4, 5], 4));
}
