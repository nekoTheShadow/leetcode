impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        let s = s.chars().collect::<Vec<_>>();
        let n = s.len();
        let mut c = vec![0, 0, 0];
        let mut l = 0;
        let mut ret = 0;

        for r in 0..n {
            c[index(s[r])] += 1;
            while c[0] > 0 && c[1] > 0 && c[2] > 0 {
                ret += n - r;
                c[index(s[l])] -= 1;
                l += 1;
            }
        }

        ret as i32
    }
}

fn index(ch: char) -> usize {
    (ch as usize) - ('a' as usize)
}

struct Solution;

fn main() {
    assert_eq!(Solution::number_of_substrings("abcabc".into()), 10);
    assert_eq!(Solution::number_of_substrings("aaacb".into()), 3);
    assert_eq!(Solution::number_of_substrings("abc".into()), 1);
}
