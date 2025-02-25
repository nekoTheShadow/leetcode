impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        let mut odd_count = 0;
        let mut even_count = 1;
        let mut count = 0;
        let mut total = 0;
        let m = 1_000_000_000 + 7;
        for v in arr {
            total += v;
            if total % 2 == 0 {
                count += odd_count;
                even_count += 1;
            } else {
                count += even_count;
                odd_count += 1;
            }
            count %= m;
        }
        count
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::num_of_subarrays(vec![1, 3, 5]), 4);
    assert_eq!(Solution::num_of_subarrays(vec![2, 4, 6]), 0);
    assert_eq!(Solution::num_of_subarrays(vec![1, 2, 3, 4, 5, 6, 7]), 16);
}
