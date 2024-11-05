impl Solution {
    pub fn min_changes(s: String) -> i32 {
        let mut pre = '_';
        let mut count = 0;
        let mut ret = 0;
        for cur in s.chars() {
            if pre == cur {
                count += 1;
            } else {
                if count % 2 == 0 {
                    pre = cur;
                    count = 1;
                } else {
                    count += 1;
                    ret += 1;
                }
            }
        }
        ret
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::min_changes("1001".into()), 2);
    assert_eq!(Solution::min_changes("10".into()), 1);
    assert_eq!(Solution::min_changes("0000".into()), 0);
    assert_eq!(Solution::min_changes("11000111".into()), 1);
}
