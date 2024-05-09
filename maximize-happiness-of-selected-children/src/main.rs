impl Solution {
    pub fn maximum_happiness_sum(happiness: Vec<i32>, k: i32) -> i64 {
        let mut happiness = happiness;
        happiness.sort();
        happiness.reverse();
        (0..k).map(|i| 0.max(happiness[i as usize] as i64 - i as i64)).sum()
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::maximum_happiness_sum(vec![1,2,3], 2));
    println!("{}", Solution::maximum_happiness_sum(vec![1,1,1,1], 2));
    println!("{}", Solution::maximum_happiness_sum(vec![2,3,4,5], 1));
    println!("{}", Solution::maximum_happiness_sum(vec![12,1,42], 3));
}
