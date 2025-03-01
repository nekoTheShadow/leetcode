

impl Solution {
    pub fn len_longest_fib_subseq(arr: Vec<i32>) -> i32 {
        let n = arr.len();
        let mut dp = vec![vec![-1; n]; n];
        for i in 0..n {
            for j in i + 1..n {
                dp[i][j] = 2;
            }
        }

        for pre in 0..n {
            for cur in pre + 1..n {
                if dp[pre][cur] == -1 {
                    continue;
                }
                for nxt in cur+1..n {
                    if arr[pre] + arr[cur] == arr[nxt] {
                        dp[cur][nxt] = std::cmp::max(dp[cur][nxt], dp[pre][cur] + 1);
                    }   
                }
            }
        }

        let max = *dp.iter().flatten().max().unwrap();
        if max >= 3 {
            max
        } else {
            0
        }
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::len_longest_fib_subseq(vec![1, 2, 3, 4, 5, 6, 7, 8]),
        5
    );
    assert_eq!(
        Solution::len_longest_fib_subseq(vec![1, 3, 7, 11, 12, 14, 18]),
        3
    );
}
