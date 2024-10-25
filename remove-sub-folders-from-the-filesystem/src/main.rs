use std::collections::VecDeque;

impl Solution {
    pub fn remove_subfolders(folder: Vec<String>) -> Vec<String> {
        let mut folders = folder
            .iter()
            .map(|f| f.split("/").collect::<Vec<_>>())
            .collect::<Vec<_>>();
        folders.sort();

        let mut stack: VecDeque<Vec<&str>> = VecDeque::new();
        for c in folders {
            if let Some(p) = stack.back() {
                let p_len = p.len();
                let c_len = c.len();
                if !(p_len <= c_len && (0..p_len).all(|i| p[i] == c[i])) {
                    stack.push_back(c);
                }
            } else {
                stack.push_back(c);
            }
        }
        stack.into_iter().map(|v| v.join("/")).collect()
    }
}

struct Solution;

fn main() {
    check(
        &["/a", "/a/b", "/c/d", "/c/d/e", "/c/f"],
        &mut ["/a", "/c/d", "/c/f"],
    );
    check(&["/a", "/a/b/c", "/a/b/d"], &mut ["/a"]);
    check(
        &["/a/b/c", "/a/b/ca", "/a/b/d"],
        &mut ["/a/b/c", "/a/b/ca", "/a/b/d"],
    );
}

fn check(input: &[&str], expected: &mut [&str]) {
    let mut actual = Solution::remove_subfolders(input.iter().map(|s| String::from(*s)).collect());
    actual.sort();
    expected.sort();
    assert_eq!(actual, expected);
}
