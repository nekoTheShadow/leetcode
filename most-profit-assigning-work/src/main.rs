impl Solution {
    pub fn max_profit_assignment(difficulty: Vec<i32>, profit: Vec<i32>, worker: Vec<i32>) -> i32 {
        let mut works = difficulty.iter().zip(profit.iter()).collect::<Vec<_>>();
        works.sort_by_key(|(&d, &p)| (d, -p));

        let mut max_profits = Vec::new();
        for (_d, p) in &works {
            if max_profits.is_empty() {
                max_profits.push(p);
            } else {
                let max_profit = max_profits[max_profits.len() - 1];
                max_profits.push(max_profit.max(p));
            }
        }

        let mut ret = 0;
        for w in worker {
            match works.binary_search_by_key(&w, |&(d, _p)| *d) {
                Ok(r) => {
                    ret += *max_profits[r];
                }
                Err(r) => {
                    if r > 0 {
                        ret += *max_profits[r - 1];
                    }
                }
            }
        }

        ret
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::max_profit_assignment(
            vec![2, 4, 6, 8, 10],
            vec![10, 20, 30, 40, 50],
            vec![4, 5, 6, 7]
        )
    );
    println!(
        "{}",
        Solution::max_profit_assignment(vec![85, 47, 57], vec![24, 66, 99], vec![40, 25, 25])
    );
}
