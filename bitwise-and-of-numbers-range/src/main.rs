
impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        let left = left as u128;
        let right = right as u128;

        let mut ret = 0u128;
        for n in 1..=32 {
            let p = 2u128.pow(n-1);
            let q = 2u128.pow(n);
            if left/q==right/q && p<=left%q && p<=left%q {
                ret |= 1<<(n-1);
            }
        }

        ret as i32
    }
}

struct Solution{}

fn main() {
    println!("{}", Solution::range_bitwise_and(5, 7));
    println!("{}", Solution::range_bitwise_and(0, 0));
    println!("{}", Solution::range_bitwise_and(1, 2147483647));
}
