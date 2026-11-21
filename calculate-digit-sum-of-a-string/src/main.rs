impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        let k = k as usize;

        let mut t = s
            .chars()
            .map(|ch| ch.to_digit(10).unwrap() as usize)
            .collect::<Vec<_>>();
        while t.len() > k {
            t = round(t, k);
        }
        t.iter().map(|d| d.to_string()).collect()
    }
}

fn round(t: Vec<usize>, k: usize) -> Vec<usize> {
    t.chunks(k)
        .flat_map(|digits| split(digits.iter().sum()).into_iter())
        .collect()
}

fn split(mut x: usize) -> Vec<usize> {
    if x == 0 {
        return vec![0];
    }

    let mut digits = Vec::new();
    while x > 0 {
        digits.push(x % 10);
        x /= 10;
    }
    digits.reverse();
    return digits;
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
        let s: String = "11111222223".to_string();
        let k: i32 = 3;
        assert_eq!(Solution::digit_sum(s, k), "135")
    }
    #[test]
    fn example2() {
        let s: String = "00000000".to_string();
        let k: i32 = 3;
        assert_eq!(Solution::digit_sum(s, k), "000")
    }
}
