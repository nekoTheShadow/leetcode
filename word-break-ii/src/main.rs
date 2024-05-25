impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        let mut ret = Vec::new();
        Self::backtrack(&s, &word_dict, 0, &mut Vec::new(), &mut ret);
        ret
    }

    pub fn backtrack(s: &str, word_dict: &Vec<String>, cur: usize, set: &mut Vec<String>, ret: &mut Vec<String>) {
        if cur == s.len() {
            ret.push(set.join(" "));
            return;
        }

        for word in word_dict {
            if s[cur..].starts_with(word) {
                set.push(word.to_string());
                Self::backtrack(s, word_dict, cur+word.len(), set, ret);
                set.pop();
            }
        }
    }
}

struct Solution;

fn main() {
    println!("{:?}", Solution::word_break("catsanddog".to_string(), ["cat","cats","and","sand","dog"].map(|s| s.to_string()).to_vec()));
    println!("{:?}", Solution::word_break("pineapplepenapple".to_string(), ["apple","pen","applepen","pine","pineapple"].map(|s| s.to_string()).to_vec()));
    println!("{:?}", Solution::word_break("catsandog".to_string(), ["cats","dog","sand","and","cat"].map(|s| s.to_string()).to_vec()));
}
