use std::collections::HashMap;

impl Solution {
    pub fn shortest_beautiful_substring(s: String, k: i32) -> String {
        let n = s.len();
        let mut d = vec![0; n + 1];
        for (i, ch) in s.chars().enumerate() {
            if ch == '1' {
                d[i + 1] = d[i] + 1;
            } else {
                d[i + 1] = d[i];
            }
        }

        let mut h = HashMap::new();
        let mut ret = "";
        for j in 0..n + 1 {
            if let Some(&i) = h.get(&(d[j] - k)) {
                ret = minimum(ret, &s[i..j])
            }
            h.insert(d[j], j);
        }
        ret.into()
    }
}

fn minimum<'a>(a1: &'a str, a2: &'a str) -> &'a str {
    // どちらかが空文字列なら、もう片方を返す
    if a1.is_empty() {
        return a2;
    }
    if a2.is_empty() {
        return a1;
    }

    // (長さ, 文字列自体) のタプルを作って比較する
    // 先に「長さ」が比較され、同じなら「辞書順」で比較される
    if (a1.len(), &a1) < (a2.len(), &a2) {
        a1
    } else {
        a2
    }
}


struct Solution;

fn main() {
    Solution::shortest_beautiful_substring("100011001".to_string(), 3);
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let s = "100011001";
        let k = 3;
        let output = "11001";
        assert_eq!(Solution::shortest_beautiful_substring(s.into(), k), output)
    }

    #[test]
    fn example2() {
        let s = "1011";
        let k = 2;
        let output = "11";
        assert_eq!(Solution::shortest_beautiful_substring(s.into(), k), output)
    }

    #[test]
    fn example3() {
        let s = "000";
        let k = 1;
        let output = "";
        assert_eq!(Solution::shortest_beautiful_substring(s.into(), k), output)
    }
}
