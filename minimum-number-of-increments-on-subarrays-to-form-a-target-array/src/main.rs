impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        let mut tot = target[0];
        for i in 1..target.len() {
            if target[i - 1] < target[i] {
                tot += target[i] - target[i - 1]
            }
        }
        tot
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn example1() {
        let target = vec![1, 2, 3, 2, 1];
        let output = 3;
        assert_eq!(Solution::min_number_operations(target), output);
    }

    #[test]
    fn example2() {
        let target = vec![3, 1, 1, 2];
        let output = 4;
        assert_eq!(Solution::min_number_operations(target), output);
    }

    #[test]
    fn example3() {
        let target = vec![3, 1, 5, 4, 2];
        let output = 7;
        assert_eq!(Solution::min_number_operations(target), output);
    }
}
