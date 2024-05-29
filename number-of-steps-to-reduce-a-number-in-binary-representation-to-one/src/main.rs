impl Solution {
    pub fn num_steps(s: String) -> i32 {
        let mut a = s
            .chars()
            .map(|c| if c == '0' { 0 } else { 1 })
            .collect::<Vec<_>>();
        let mut count = 0;

        while a != vec![1] {
            count += 1;
            let n = a.len();
            if a[n - 1] == 0 {
                // even
                a.pop();
            } else {
                // odd
                let mut rest = true;
                for i in (0..n).rev() {
                    if a[i] == 1 {
                        a[i] = 0;
                    } else {
                        a[i] = 1;
                        rest = false;
                        break;
                    }
                }

                if rest {
                    a.insert(0, 1);
                }
            }
        }

        count
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::num_steps("1101".to_string()));
    println!("{}", Solution::num_steps("10".to_string()));
    println!("{}", Solution::num_steps("1".to_string()));
}
