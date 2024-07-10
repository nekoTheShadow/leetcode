impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        let mut depth = 0;
        for log in logs {
            match log.as_str() {
                "./" => continue,
                "../" => {
                    if depth > 0 {
                        depth -= 1
                    }
                }
                _ => depth += 1,
            }
        }
        depth
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::min_operations(
            ["d1/", "d2/", "../", "d21/", "./"]
                .map(|s| s.to_string())
                .to_vec()
        ),
        2
    );
    assert_eq!(
        Solution::min_operations(
            ["d1/", "d2/", "./", "d3/", "../", "d31/"]
                .map(|s| s.to_string())
                .to_vec()
        ),
        3
    );
    assert_eq!(
        Solution::min_operations(["d1/", "../", "../", "../"].map(|s| s.to_string()).to_vec()),
        0
    );
}
