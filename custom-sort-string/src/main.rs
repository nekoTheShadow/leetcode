impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        let mut counter = vec![0; 26];
        fn ord(c: char) -> usize {
            c as usize - 'a' as usize
        }

        for c in s.chars() {
            counter[ord(c)] += 1;
        }
        
        let mut ret = String::new();
        for c in order.chars() {
            for _ in 0..counter[ord(c)] {
                ret.push(c);
            }
            counter[ord(c)] = 0;
        }

        for c in 'a'..='z' {
            for _ in 0..counter[ord(c)] {
                ret.push(c);
            }
            counter[ord(c)] = 0;
        }

        ret
    }
}
struct Solution{}

fn main() {
    println!("{}", Solution::custom_sort_string("cba".to_string(), "abcd".to_string()));
    println!("{}", Solution::custom_sort_string("bcafg".to_string(), "abcd".to_string()));
}
