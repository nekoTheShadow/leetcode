use std::collections::HashMap;

impl Solution {
    pub fn mincost_tickets(days: Vec<i32>, costs: Vec<i32>) -> i32 {
        solve(&mut HashMap::new(), &days, &costs, 0, 0)
    }
}

fn solve(
    memo: &mut HashMap<(usize, i32), i32>,
    days: &Vec<i32>,
    costs: &Vec<i32>,
    i: usize,
    ticket: i32,
) -> i32 {
    if i == days.len() {
        return 0;
    }
    if let Some(v) = memo.get(&(i, ticket)) {
        return *v;
    }

    let a = solve(memo, days, costs, i + 1, days[i] + 0) + costs[0];
    let b = solve(memo, days, costs, i + 1, days[i] + 6) + costs[1];
    let c = solve(memo, days, costs, i + 1, days[i] + 29) + costs[2];
    let v = if ticket < days[i] {
        *[a, b, c].iter().min().unwrap()
    } else {
        let d = solve(memo, days, costs, i + 1, ticket);
        *[a, b, c, d].iter().min().unwrap()
    };

    memo.insert((i, ticket), v);
    v
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::mincost_tickets(vec![1, 4, 6, 7, 8, 20], vec![2, 7, 15]),
        11
    );
    assert_eq!(
        Solution::mincost_tickets(vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31], vec![2, 7, 15]),
        17
    );
}
