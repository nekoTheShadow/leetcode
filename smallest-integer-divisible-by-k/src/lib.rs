impl Solution {
    pub fn smallest_repunit_div_by_k(k: i32) -> i32 {
        if k % 2 == 0 || k % 5 == 0 {
            return -1;
        }

        let mut modulo = 0;
        let mut count = 1;
        loop {
            modulo = (modulo * 10 + 1) % k;
            if modulo == 0 {
                break;
            }
            count += 1
        }
        count
    }
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        assert_eq!(Solution::smallest_repunit_div_by_k(1), 1);
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::smallest_repunit_div_by_k(2), -1);
    }

    #[test]
    fn example3() {
        assert_eq!(Solution::smallest_repunit_div_by_k(3), 3);
    }
}
