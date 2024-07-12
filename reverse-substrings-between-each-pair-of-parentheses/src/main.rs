use std::collections::VecDeque;


impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        let mut stack = VecDeque::new();
        for c in s.chars() {
            if c == ')' {
                let mut queue = VecDeque::new();
                while let Some(d) = stack.pop_back() {
                    if d == '(' {
                        break;
                    }
                    queue.push_back(d);
                }
                stack.extend(queue);
            } else {
                stack.push_back(c);
            }
        } 
        stack.iter().collect()
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::reverse_parentheses("(abcd)".to_string()));
    println!("{}", Solution::reverse_parentheses("(u(love)i)".to_string()));
    println!("{}", Solution::reverse_parentheses("(ed(et(oc))el)".to_string()));
}

