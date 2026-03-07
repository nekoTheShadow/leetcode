impl Solution {
    pub fn min_flips(s: String) -> i32 {
        let n = s.len();

        let ss = s.chars().chain(s.chars()).collect::<Vec<_>>();
        let alt1 = (0..n * 2)
            .map(|i| if i % 2 == 0 { '1' } else { '0' })
            .collect::<Vec<_>>();
        let alt2 = (0..n * 2)
            .map(|i| if i % 2 == 0 { '0' } else { '1' })
            .collect::<Vec<_>>();

        let mut diff1 = 0;
        let mut diff2 = 0;
        let mut ans = std::i32::MAX;
        let mut left = 0;
        for right in 0..2 * n {
            if ss[right] != alt1[right] {
                diff1 += 1;
            }
            if ss[right] != alt2[right] {
                diff2 += 1;
            }

            if right - left + 1 > n {
                if ss[left] != alt1[left] {
                    diff1 -= 1;
                }
                if ss[left] != alt2[left] {
                    diff2 -= 1;
                }
                left += 1;
            }

            if right - left + 1 == n {
                ans = std::cmp::min(ans, diff1);
                ans = std::cmp::min(ans, diff2);
            }
        }

        ans
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
        let s = "111000";
        let output = 2;
        assert_eq!(Solution::min_flips(s.to_string()), output)
    }

    #[test]
    fn example2() {
        let s = "010";
        let output = 0;
        assert_eq!(Solution::min_flips(s.to_string()), output)
    }

    #[test]
    fn example3() {
        let s = "1110";
        let output = 1;
        assert_eq!(Solution::min_flips(s.to_string()), output)
    }
}
