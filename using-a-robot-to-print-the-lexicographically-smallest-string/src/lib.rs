use std::collections::BTreeMap;

impl Solution {
    pub fn robot_with_string(s: String) -> String {
        let mut map = BTreeMap::new();
        for ch in s.chars() {
            *map.entry(ch).or_insert(0) += 1;
        }

        let mut t = Vec::new();
        let mut p = String::new();
        for ch in s.chars() {
            t.push(ch);
            if map[&ch] == 1 {
                map.remove(&ch);
            } else {
                *map.get_mut(&ch).unwrap() -= 1;
            }

            if let Some((min_ch, _)) = map.first_key_value() {
                while !t.is_empty() && t.last().unwrap() <= min_ch {
                    p.push(t.pop().unwrap());
                }
            }
        }

        p.extend(t.iter().rev());
        p
    }
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        testing("zza", "azz");
    }

    #[test]
    fn example2() {
        testing("bac", "abc");
    }

    #[test]
    fn example3() {
        testing("bdda", "addb");
    }

    #[test]
    fn ng1() {
        testing("bydizfve", "bdevfziy");
    }

    #[test]
    fn ng2() {
        testing("ibwqrkn", "biknrqw");
    }

    fn testing(s: &str, output: &str) {
        assert_eq!(Solution::robot_with_string(s.into()), output.to_string())
    }
}
