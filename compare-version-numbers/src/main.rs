impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        let a1 = version1.split(".").collect::<Vec<_>>();
        let a2 = version2.split(".").collect::<Vec<_>>();
        for i in 0..a1.len().max(a2.len()) {
            let t1 = a1.get(i).unwrap_or(&"0").parse::<i32>().unwrap();
            let t2 = a2.get(i).unwrap_or(&"0").parse::<i32>().unwrap();
            if t1 < t2 {
                return -1;
            }
            if t1 > t2 {
                return 1;
            }
        }
        0
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::compare_version("1.01".to_string(), "1.001".to_string())
    );
    println!(
        "{}",
        Solution::compare_version("1.0".to_string(), "1.0.0".to_string())
    );
    println!(
        "{}",
        Solution::compare_version("0.1".to_string(), "1.1".to_string())
    );
}
