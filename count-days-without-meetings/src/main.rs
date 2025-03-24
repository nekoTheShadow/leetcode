use std::cmp::max;

impl Solution {
    pub fn count_days(days: i32, meetings: Vec<Vec<i32>>) -> i32 {
        let mut meetings = meetings
            .iter()
            .map(|meeting| (meeting[0], meeting[1]))
            .collect::<Vec<_>>();
        meetings.sort();

        let mut total = 0;
        let mut x = 0;
        for (s, e) in &meetings {
            total += max(s - x - 1, 0);
            x = max(x, *e);
        }
        total += max(days - x, 0);
        total
    }
}

struct Solution;

fn main() {
    testing(10, &[[5, 7], [1, 3], [9, 10]], 2);
    testing(5, &[[2, 4], [1, 3]], 1);
    testing(6, &[[1, 6]], 0);
    testing(8, &[[3, 4], [4, 8], [2, 5], [3, 8]], 1);
    testing(4, &[[2, 3], [1, 2], [2, 3], [2, 4], [1, 2], [1, 3]], 0);
    testing(
        57,
        &[
            [3, 49],
            [23, 44],
            [21, 56],
            [26, 55],
            [23, 52],
            [2, 9],
            [1, 48],
            [3, 31],
        ],
        1,
    );
}

fn testing(days: i32, meetings: &[[i32; 2]], output: i32) {
    let actual = Solution::count_days(
        days,
        meetings.iter().map(|meeting| meeting.to_vec()).collect(),
    );
    assert_eq!(actual, output);
}
