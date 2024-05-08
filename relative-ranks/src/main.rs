use std::cmp::Reverse;

impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        let mut a = score.iter().enumerate().collect::<Vec<_>>(); // (index, score)
        a.sort_by_key(|(_i, s)| Reverse(**s));

        let mut b = a.iter().enumerate().map(|(r, (i, _s))| (i, r)).collect::<Vec<_>>(); // (index, rank)
        b.sort_by_key(|(i, _r)| **i);

        b.iter().map(|(_i, r)|
            match r {
                0 => "Gold Medal".to_string(),
                1 => "Silver Medal".to_string(),
                2 => "Bronze Medal".to_string(),
                _ => (r + 1).to_string(),
            }
        ).collect::<Vec<_>>()
    }
}

struct Solution;

fn main() {
    println!("{:?}", Solution::find_relative_ranks(vec![5,4,3,2,1]));
    println!("{:?}", Solution::find_relative_ranks(vec![10,3,8,9,4]));
}
