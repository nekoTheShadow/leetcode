impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        let mut result = Vec::new();

        let mut up = true;
        for &digit in digits.iter().rev() {
            if up {
                if digit == 9 {
                    result.push(0);
                } else {
                    result.push(digit + 1);
                    up = false;
                }
            } else {
                result.push(digit);
            }
        }

        if up {
            result.push(1);
        }

        result.reverse();
        result
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let digits = [1, 2, 3];
        let output = [1, 2, 4];
        assert_eq!(Solution::plus_one(digits.to_vec()), output.to_vec());
    }

    #[test]
    fn example2() {
        let digits = [4, 3, 2, 1];
        let output = [4, 3, 2, 2];
        assert_eq!(Solution::plus_one(digits.to_vec()), output.to_vec());
    }

    #[test]
    fn example3() {
        let digits = [9];
        let output = [1, 0];
        assert_eq!(Solution::plus_one(digits.to_vec()), output.to_vec());
    }
}
