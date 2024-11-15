impl Solution {
    pub fn find_length_of_shortest_subarray(arr: Vec<i32>) -> i32 {
        let mut r = arr.len() - 1;
        while r > 0 && arr[r - 1] <= arr[r] {
            r -= 1;
        }

        let mut ans = r;
        let mut l = 0;
        while l < r && (l == 0 || arr[l - 1] <= arr[l]) {
            while r < arr.len() && arr[l] > arr[r] {
                r += 1;
            }
            ans = std::cmp::min(ans, r - l - 1);
            l += 1;
        }
        ans as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::find_length_of_shortest_subarray(vec![1, 2, 3, 10, 4, 2, 3, 5]),
        3
    );
    assert_eq!(
        Solution::find_length_of_shortest_subarray(vec![5, 4, 3, 2, 1]),
        4
    );
    assert_eq!(Solution::find_length_of_shortest_subarray(vec![1, 2, 3]), 0);
    assert_eq!(
        Solution::find_length_of_shortest_subarray(vec![13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20]),
        8
    );
}
