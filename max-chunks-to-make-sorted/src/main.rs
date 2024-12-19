use std::collections::HashSet;

impl Solution {
    pub fn max_chunks_to_sorted(arr: Vec<i32>) -> i32 {
        let n = arr.len();
        let mut max = 0;

        for bit in 0..(1 << n) {
            let mut chunks: Vec<Vec<i32>> = vec![];
            let mut y = 2;
            for i in 0..n {
                let x = (bit >> i) & 1;
                if let Some(chunk) = chunks.last_mut() {
                    if x == y {
                        chunk.push(arr[i]);
                    } else {
                        chunks.push(vec![arr[i]]);
                    }
                } else {
                    chunks.push(vec![arr[i]]);
                }
                y = x;
            }

            if check(&chunks) {
                max = std::cmp::max(max, chunks.len());
            }
        }

        max as i32
    }
}

fn check(chunks: &Vec<Vec<i32>>) -> bool {
    let mut min = 0_i32;
    for chunk in chunks {
        let n = chunk.len() as i32;
        let set = (min..min + n).collect::<HashSet<_>>();
        if !chunk.iter().all(|v| set.contains(v)) {
            return false;
        }
        min += n;
    }
    true
}

struct Solution;

fn main() {
    println!("{}", Solution::max_chunks_to_sorted(vec![4, 3, 2, 1, 0]));
    println!("{}", Solution::max_chunks_to_sorted(vec![1, 0, 2, 3, 4]));
}
