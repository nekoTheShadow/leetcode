impl Solution {
    pub fn length_after_transformations(s: String, t: i32) -> i32 {
        let m = 1_000_000_000 + 7;

        let mut a = vec![0_i32; 26];
        for ch in s.chars() {
            a[ord(ch)] += 1;
            a[ord(ch)] %= m;
        }

        for _ in 0..t {
            let mut b = vec![0_i32; 26];
            for ch in 'a'..='y' {
                b[ord(ch) + 1] += a[ord(ch)];
                b[ord(ch) + 1] %= m;
            }
            b[ord('a')] += a[ord('z')];
            b[ord('a')] %= m;
            b[ord('b')] += a[ord('z')];
            b[ord('b')] %= m;

            a = b;
        }

        let mut total = 0;
        for v in a {
            total += v;
            total %= m;
        }
        total
    }
}

fn ord(ch: char) -> usize {
    (ch as usize) - ('a' as usize)
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::length_after_transformations("abcyy".to_string(), 2),
        7
    );
    assert_eq!(
        Solution::length_after_transformations("azbk".to_string(), 1),
        5
    );
}
