use std::collections::{BTreeSet, HashMap};

impl Solution {
    pub fn smallest_chair(times: Vec<Vec<i32>>, target_friend: i32) -> i32 {
        let mut tuples = Vec::new();
        for (friend, time) in times.iter().enumerate() {
            let arrival = time[0];
            let leaving = time[1];
            tuples.push((arrival, 1, friend));
            tuples.push((leaving, 0, friend));
        }
        tuples.sort();

        let mut empty_chairs = (0..times.len()).collect::<BTreeSet<_>>();
        let mut chairs = HashMap::new(); // key=friend, value=chair
        for (_time, status, friend) in tuples {
            if status == 1 {
                // arrival
                let chair = empty_chairs.pop_first().unwrap();
                chairs.insert(friend, chair);
            } else {
                // leaving
                let chair = chairs[&friend];
                empty_chairs.insert(chair);
            }
        }

        chairs[&(target_friend as usize)] as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::smallest_chair([[1,4],[2,3],[4,6]].map(|a| a.to_vec()).to_vec(), 1), 1);
    assert_eq!(Solution::smallest_chair( [[3,10],[1,5],[2,6]].map(|a| a.to_vec()).to_vec(), 0), 2);
}
