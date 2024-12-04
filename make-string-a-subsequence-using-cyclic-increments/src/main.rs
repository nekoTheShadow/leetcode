impl Solution {
    pub fn can_make_subsequence(str1: String, str2: String) -> bool {
        let t1 = str1
            .chars()
            .map(|ch| (ch as i32) - ('a' as i32))
            .collect::<Vec<_>>();
        let t2 = str2
            .chars()
            .map(|ch| (ch as i32) - ('a' as i32))
            .collect::<Vec<_>>();
        Self::check(&t1, &t2, 0, 0)
    }

    pub fn check(t1: &[i32], t2: &[i32], i1: usize, i2: usize) -> bool {
        if t2.len() == i2 {
            return true;
        }
        if t1.len() == i1 {
            return false;
        }

        if t1[i1] == t2[i2] || (t1[i1] + 1) % 26 == t2[i2] {
            return Self::check(t1, t2, i1 + 1, i2 + 1);
        } else {
            return Self::check(t1, t2, i1 + 1, i2);
        }
    }
}

struct Solution;

fn main() {
    assert_eq!(
        true,
        Solution::can_make_subsequence("abc".into(), "ad".into())
    );
    assert_eq!(
        true,
        Solution::can_make_subsequence("zc".into(), "ad".into())
    );
    assert_eq!(
        false,
        Solution::can_make_subsequence("ab".into(), "d".into())
    );
}
