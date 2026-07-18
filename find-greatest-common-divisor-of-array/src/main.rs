impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        let mx = nums.iter().max().unwrap();
        let mn = nums.iter().min().unwrap();
        gcd(*mn, *mx)
    }
}

fn gcd(a: i32, b: i32) -> i32 {
    if a > b {
        return gcd(b, a);
    }
    if b % a == 0 {
        return a;
    }
    gcd(b % a, a)
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
        assert_eq!(Solution::find_gcd(vec![2, 5, 6, 9, 10]), 2)
    }

    #[test]
    fn example2() {
        assert_eq!(Solution::find_gcd(vec![7, 5, 6, 8, 3]), 1)
    }

    #[test]
    fn example3() {
        assert_eq!(Solution::find_gcd(vec![3, 3]), 3)
    }
}
