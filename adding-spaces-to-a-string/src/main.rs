impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        let mut pre = 0;
        let mut tokens = Vec::new();
        for space in spaces.iter().map(|space| *space as usize) {
            tokens.push(&s[pre..space]);
            pre = space;
        }
        tokens.push(&s[pre..]);
        tokens.join(" ")
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::add_spaces("LeetcodeHelpsMeLearn".to_string(), vec![8, 13, 15]),
        "Leetcode Helps Me Learn"
    );
    assert_eq!(
        Solution::add_spaces("icodeinpython".to_string(), vec![1, 5, 7, 9]),
        "i code in py thon"
    );
    assert_eq!(
        Solution::add_spaces("spacing".to_string(), vec![0,1,2,3,4,5,6]),
        " s p a c i n g"
    );
}
