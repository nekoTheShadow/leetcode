use std::{cmp::Reverse, collections::BinaryHeap};

impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        let mut bricks = bricks;
        let mut ladders = ladders;

        let mut heap = BinaryHeap::new();
        let mut i = 0;
        while i < heights.len() {
            if i == heights.len() - 1 {
                break;
            }

            if heights[i] >= heights[i + 1] {
                i += 1;
                continue;
            }

            heap.push(Reverse(heights[i + 1] - heights[i]));

            if ladders > 0 {
                ladders -= 1;
                i += 1;
            } else {
                match heap.pop() {
                    Some(Reverse(min)) => {
                        if min <= bricks {
                            bricks -= min;
                            i += 1;
                        } else {
                            break;
                        }
                    }
                    None => break,
                }
            }
        }

        i as i32
    }
}

struct Solution {}

fn main() {
    println!(
        "{}",
        Solution::furthest_building(vec![4, 2, 7, 6, 9, 14, 12], 5, 1)
    );
    println!(
        "{}",
        Solution::furthest_building(vec![4, 12, 2, 7, 3, 18, 20, 3, 19], 10, 2)
    );
    println!("{}", Solution::furthest_building(vec![14, 3, 19, 3], 17, 0));
}
