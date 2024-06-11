impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        let mut counter = vec![0; 1001];
        for x in arr1 {
            counter[x as usize] += 1;
        }

        let mut ret = Vec::new();
        for x in arr2 {
            for _ in 0..counter[x as usize] {
                ret.push(x);
            }
            counter[x as usize] = 0;
        }

        for x in 0..counter.len() {
            for _ in 0..counter[x as usize] {
                ret.push(x as i32);
            }
        }

        return ret;
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::relative_sort_array(
            vec![2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19],
            vec![2, 1, 4, 3, 9, 6]
        ),
        vec![2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]
    );
    assert_eq!(
        Solution::relative_sort_array(vec![28, 6, 22, 8, 44, 17], vec![22, 28, 8, 6]),
        vec![22, 28, 8, 6, 17, 44]
    );
}
