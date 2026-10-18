impl Solution {
    pub fn max_sum_of_squares(num: i32, sum: i32) -> String {
        let mut sum = sum;
        let mut ans = Vec::new();
        for _ in 0..num {
            let v = std::cmp::min(sum, 9);
            ans.push(v);
            sum -= v;
        }

        if sum == 0 {
            ans.iter().map(|v| v.to_string()).collect()
        } else {
            "".to_string()
        }
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let num = 2;
        let sum = 3;
        let output = "30";
        assert_eq!(Solution::max_sum_of_squares(num, sum), output)
    }

    #[test]
    fn example2() {
        let num = 2;
        let sum = 17;
        let output = "98";
        assert_eq!(Solution::max_sum_of_squares(num, sum), output)
    }

    #[test]
    fn example3() {
        let num = 1;
        let sum = 10;
        let output = "";
        assert_eq!(Solution::max_sum_of_squares(num, sum), output)
    }
}
