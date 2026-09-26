use std::collections::HashMap;

impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        let mut dict = knowledge
            .iter()
            .map(|row| (row[0].to_string(), row[1].to_string()))
            .collect::<HashMap<_, _>>();

        let mut inside = false;
        let mut key = String::new();
        let mut ret = String::new();

        for ch in s.chars() {
            if ch == '(' {
                inside = true;
            } else if ch == ')' {
                if let Some(val) = dict.get(&key) {
                    ret.push_str(val);
                } else {
                    ret.push('?');
                }

                inside = false;
                key.clear();
            } else {
                if inside {
                    key.push(ch);
                } else {
                    ret.push(ch);
                }
            }
        }

        ret
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use std::assert_eq;

    use crate::Solution;

    #[test]
    fn example1() {
        let s = "(name)is(age)yearsold";
        let knowledge = [["name", "bob"], ["age", "two"]];
        let output = "bobistwoyearsold";
        assert_eq!(
            Solution::evaluate(
                s.into(),
                knowledge.map(|row| row.map(String::from).to_vec()).to_vec()
            ),
            output.to_string()
        )
    }

    #[test]
    fn example2() {
        let s = "hi(name)";
        let knowledge = [["a", "b"]];
        let output = "hi?";
        assert_eq!(
            Solution::evaluate(
                s.into(),
                knowledge.map(|row| row.map(String::from).to_vec()).to_vec()
            ),
            output.to_string()
        )
    }

    #[test]
    fn example3() {
        let s = "(a)(a)(a)aaa";
        let knowledge = [["a", "yes"]];
        let output = "yesyesyesaaa";
        assert_eq!(
            Solution::evaluate(
                s.into(),
                knowledge.map(|row| row.map(String::from).to_vec()).to_vec()
            ),
            output.to_string()
        )
    }
}
