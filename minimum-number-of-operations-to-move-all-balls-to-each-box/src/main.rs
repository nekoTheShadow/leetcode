impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        let n = boxes.len();
        let s = boxes.chars().collect::<Vec<_>>();

        let mut b1 = vec![0; n];
        let mut b2 = vec![0; n];
        for i in 0..n {
            if i >= 1 {
                b1[i] += b1[i - 1];
            }
            if s[i] == '1' {
                b1[i] += 1;
            }
        }
        for i in (0..n).rev() {
            if i + 1 < n {
                b2[i] += b2[i + 1];
            }
            if s[i] == '1' {
                b2[i] += 1;
            }
        }

        let mut m1 = vec![0; n];
        let mut m2 = vec![0; n];
        for i in 0..n - 1 {
            m1[i + 1] = b1[i] + m1[i];
        }
        for i in (1..n).rev() {
            m2[i - 1] = b2[i] + m2[i];
        }

        m1.iter().zip(m2.iter()).map(|(v1, v2)| v1 + v2).collect()
    }
}

struct Solution;

fn main() {
    println!("{:?}", Solution::min_operations("110".into()));
    println!("{:?}", Solution::min_operations("001011".into()));
}
