impl Solution {
    pub fn count_symmetric_integers(low: i32, high: i32) -> i32 {
        (low..=high).filter(|&x| is_symmetric(x)).count() as i32
    }
}

fn is_symmetric(mut x: i32) -> bool {
    let mut digits = Vec::new();
    while x > 0 {
        digits.push(x % 10);
        x /= 10;
    }

    let n = digits.len();
    if n % 2 != 0 {
        return false;
    }
    digits[..n / 2].iter().sum::<i32>() == digits[n / 2..].iter().sum::<i32>()
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        assert_eq!(Solution::count_symmetric_integers(1, 100), 9);
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::count_symmetric_integers(1200, 1230), 4);
    }
}
