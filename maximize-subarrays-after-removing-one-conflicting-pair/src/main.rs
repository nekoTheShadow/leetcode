impl Solution {
    pub fn max_subarrays(n: i32, conflicting_pairs: Vec<Vec<i32>>) -> i64 {
        let n = n as usize;

        let mut right = vec![vec![]; n + 1];
        for conflicting_pair in conflicting_pairs {
            let a = *conflicting_pair.iter().min().unwrap() as usize;
            let b = *conflicting_pair.iter().max().unwrap() as usize;
            right[b].push(a);
        }

        let mut ans = 0;
        let mut left = [0, 0];
        let mut imp = vec![0; n + 1];
        for r in 1..n + 1 {
            for &l in &right[r] {
                left = *[left, [l, left[0]], [left[0], l]].iter().max().unwrap();
            }
            ans += r - left[0];
            imp[left[0]] += left[0] - left[1];
        }

        (ans + imp.iter().max().unwrap()) as i64
    }
}

pub struct Solution;

fn main() {
    example1();
    example2();
}

fn example1() {
    let n = 4;
    let conflicting_pairs = [[2, 3], [1, 4]];
    let output = 9;
    assert_eq!(
        Solution::max_subarrays(n, conflicting_pairs.iter().map(|a| a.to_vec()).collect()),
        output
    )
}

fn example2() {
    let n = 5;
    let conflicting_pairs = [[1, 2], [2, 5], [3, 5]];
    let output = 12;
    assert_eq!(
        Solution::max_subarrays(n, conflicting_pairs.iter().map(|a| a.to_vec()).collect()),
        output
    )
}
