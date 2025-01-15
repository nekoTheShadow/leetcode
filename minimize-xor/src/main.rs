impl Solution {
    pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
        let mut c = num2.count_ones();
        let mut x = 0;

        let mut i = 30;
        while c > 0 && i >= 0 {
            if (num1 >> i) & 1 == 1 {
                x |= 1 << i;
                c -= 1;
            }
            i -= 1;
        }

        i = 0;
        while c > 0 {
            if (x >> i) & 1 == 0 {
                x |= 1 << i;
                c -= 1;
            }
            i += 1;
        }

        x
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::minimize_xor(3, 5));
    println!("{}", Solution::minimize_xor(1, 12));
}
