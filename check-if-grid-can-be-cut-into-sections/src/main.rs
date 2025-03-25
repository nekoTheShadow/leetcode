use std::cmp::{max, min};

impl Solution {
    pub fn check_valid_cuts(n: i32, rectangles: Vec<Vec<i32>>) -> bool {
        let mut ranges1 = Vec::new();
        let mut ranges2 = Vec::new();
        for rectangle in &rectangles {
            let sx = rectangle[0];
            let sy = rectangle[1];
            let ex = rectangle[2];
            let ey = rectangle[3];
            ranges1.push((sx, ex));
            ranges2.push((sy, ey));
        }
        ranges1.sort();
        ranges2.sort();
        check(&ranges1) || check(&ranges2)
    }
}

fn check(ranges: &Vec<(i32, i32)>) -> bool {
    let mut stack = Vec::new();
    for &(s1, e1) in ranges {
        if let Some(&(s2, e2)) = stack.last() {
            if s1 < e2 && s2 < e1 {
                stack.pop();
                stack.push((min(s1, s2), max(e1, e2)));
            } else {
                stack.push((s1, e1));
            }
        } else {
            stack.push((s1, e1));
        }
    }
    stack.len() >= 3
}

struct Solution;

fn main() {
    testing(
        5,
        &[[1, 0, 5, 2], [0, 2, 2, 4], [3, 2, 5, 3], [0, 4, 4, 5]],
        true,
    );
    testing(
        4,
        &[[0, 0, 1, 1], [2, 0, 3, 4], [0, 2, 2, 3], [3, 0, 4, 3]],
        true,
    );
    testing(
        4,
        &[
            [0, 2, 2, 4],
            [1, 0, 3, 2],
            [2, 2, 3, 4],
            [3, 0, 4, 2],
            [3, 2, 4, 4],
        ],
        false,
    );
}

fn testing(n: i32, rectancles: &[[i32; 4]], expected: bool) {
    let actual = Solution::check_valid_cuts(
        n,
        rectancles
            .iter()
            .map(|rectancle| rectancle.to_vec())
            .collect(),
    );
    assert_eq!(actual, expected);
}
