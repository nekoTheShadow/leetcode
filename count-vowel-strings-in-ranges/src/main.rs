impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let n = words.len();
        let mut d = vec![0; n + 1];
        for i in 0..n {
            if is_ok(&words[i]) {
                d[i + 1] = d[i] + 1;
            } else {
                d[i + 1] = d[i] + 0;
            }
        }

        queries
            .iter()
            .map(|query| {
                let l = query[0] as usize;
                let r = query[1] as usize;
                d[r + 1] - d[l]
            })
            .collect()
    }
}

fn is_ok(s: &String) -> bool {
    let c1 = s.chars().next().unwrap();
    let c2 = s.chars().next_back().unwrap();
    ['a', 'i', 'u', 'e', 'o'].contains(&c1) && ['a', 'i', 'u', 'e', 'o'].contains(&c2)
}

struct Solution;

fn main() {
    testing(
        &["aba", "bcb", "ece", "aa", "e"],
        &[[0, 2], [1, 4], [1, 1]],
        &[2, 3, 0],
    );
    testing(&["a", "e", "i"], &[[0, 2], [0, 1], [2, 2]], &[3, 2, 1]);
}

fn testing(words: &[&str], queries: &[[i32; 2]], expected: &[i32]) {
    let actual = Solution::vowel_strings(
        words.iter().map(|word| word.to_string()).collect(),
        queries.iter().map(|query| query.to_vec()).collect(),
    );
    assert_eq!(actual, expected);
}
