impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        let n = arr.len();
        let mut d = vec![0; n + 1];
        for i in 0..n {
            d[i + 1] = d[i] ^ arr[i];
        }

        let mut ret = 0;
        for i in 0..n {
            for k in i + 1..n {
                for j in i + 1..=k {
                    let a = d[i] ^ d[j];
                    let b = d[k + 1] ^ d[j];
                    if a == b {
                        ret += 1;
                    }
                }
            }
        }

        ret
    }
}
struct Solution;

fn main() {
    println!("{}", Solution::count_triplets(vec![2, 3, 1, 6, 7]));
    println!("{}", Solution::count_triplets(vec![1, 1, 1, 1, 1]));
}
