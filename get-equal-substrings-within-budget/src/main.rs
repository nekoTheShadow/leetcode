impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        let n = s.len();
        let d = s
            .chars()
            .zip(t.chars())
            .map(|(c1, c2)| (c1 as i32 - c2 as i32).abs())
            .collect::<Vec<_>>();

        let mut right = 0;
        let mut cost = 0;
        let mut ret = 0;
        for left in 0..n {
            while right < n && cost + d[right] <= max_cost {
                cost += d[right];
                right += 1;
            }

            ret = std::cmp::max(ret, right - left);

            if left == right {
                right += 1;
            } else {
                cost -= d[left];
            }
        }

        ret as i32
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::equal_substring("abcd".to_string(), "bcdf".to_string(), 3)
    );
    println!(
        "{}",
        Solution::equal_substring("abcd".to_string(), "cdef".to_string(), 3)
    );
    println!(
        "{}",
        Solution::equal_substring("abcd".to_string(), "acde".to_string(), 0)
    );
}
