impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        Self::dfs(n, 1, 0).unwrap()
    }

    fn dfs(n: i32, word: i32, clipboard: i32) -> Option<i32> {
        if n == word {
            return Some(0);
        }
        if n < word {
            return None;
        }

        let a = if clipboard > 0 {
            Self::dfs(n, word + clipboard, clipboard)
        } else {
            None
        };
        let b = if word > clipboard {
            Self::dfs(n, word, word)
        } else {
            None
        };

        match (a, b) {
            (None, None) => None,
            (None, Some(step)) => Some(step + 1),
            (Some(step), None) => Some(step + 1),
            (Some(step1), Some(step2)) => Some(std::cmp::min(step1, step2) + 1),
        }
    }
}
struct Solution;

fn main() {
    println!("{}", Solution::min_steps(3));
    println!("{}", Solution::min_steps(1));
}
