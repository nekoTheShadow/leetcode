impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        let n = customers.len();
        let minutes = minutes as usize;

        let mut d = vec![0; n + 1];
        for i in 0..n {
            if grumpy[i] == 1 {
                d[i + 1] = customers[i] + d[i];
            } else {
                d[i + 1] = d[i];
            }
        }

        let tot = (0..n)
            .filter(|i| grumpy[*i] == 0)
            .map(|i| customers[i])
            .sum();
        let ret = (0..n)
            .map(|i| tot + (d[std::cmp::min(i + minutes, n)] - d[i]))
            .max()
            .unwrap();
        std::cmp::max(tot, ret)
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::max_satisfied(
            vec![1, 0, 1, 2, 1, 1, 7, 5],
            vec![0, 1, 0, 1, 0, 1, 0, 1],
            3
        )
    );
    println!("{}", Solution::max_satisfied(vec![1], vec![0], 1));
}
