impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        let a1 = Self::to_tuples(start);
        let a2 = Self::to_tuples(target);
        if a1.len() != a2.len() {
            return false;
        }

        a1.iter().zip(a2.iter()).all(|(&(i1, c1), &(i2, c2))| {
            (c1 == 'L' && c2 == 'L' && i1 >= i2) || (c1 == 'R' && c2 == 'R' && i1 <= i2)
        })
    }

    fn to_tuples(s: String) -> Vec<(usize, char)> {
        s.chars()
            .enumerate()
            .filter_map(|(i, ch)| if ch == '_' { None } else { Some((i, ch)) })
            .collect()
    }
}

struct Solution;

fn main() {
    assert_eq!(
        true,
        Solution::can_change("_L__R__R_".to_string(), "L______RR".to_string())
    );
    assert_eq!(
        false,
        Solution::can_change("R_L_".to_string(), "__LR".to_string())
    );
    assert_eq!(
        false,
        Solution::can_change("_R".to_string(), "R_".to_string())
    );
}
