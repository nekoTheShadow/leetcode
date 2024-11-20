use std::collections::HashMap;

impl Solution {
    pub fn take_characters(s: String, k: i32) -> i32 {
        let mut d = HashMap::new();
        for ch in s.chars() {
            *d.entry(ch).or_insert(0) += 1;
        }
        if !['a', 'b', 'c']
            .iter()
            .all(|ch| *d.get(ch).unwrap_or(&0) >= k)
        {
            return -1;
        }

        let mut s = s.chars().collect::<Vec<_>>();
        let n = s.len();

        let mut a_left = vec![0; s.len() + 1];
        let mut b_left = vec![0; s.len() + 1];
        let mut c_left = vec![0; s.len() + 1];
        for i in 0..n {
            if s[i] == 'a' {
                a_left[i + 1] = a_left[i] + 1;
            } else {
                a_left[i + 1] = a_left[i];
            }
            if s[i] == 'b' {
                b_left[i + 1] = b_left[i] + 1;
            } else {
                b_left[i + 1] = b_left[i];
            }
            if s[i] == 'c' {
                c_left[i + 1] = c_left[i] + 1;
            } else {
                c_left[i + 1] = c_left[i];
            }
        }

        let mut a_right = 0;
        let mut b_right = 0;
        let mut c_right = 0;
        let mut ans = usize::MAX;
        s.reverse();
        for i in 0..=n {
            let a_x = bisect_left(&a_left, k - a_right);
            let b_x = bisect_left(&b_left, k - b_right);
            let c_x = bisect_left(&c_left, k - c_right);
            ans = std::cmp::min(ans, *[a_x + i, b_x + i, c_x + i].iter().max().unwrap());
            if i < n && s[i] == 'a' {
                a_right += 1;
            }
            if i < n && s[i] == 'b' {
                b_right += 1;
            }
            if i < n && s[i] == 'c' {
                c_right += 1;
            }
        }

        if ans == usize::MAX {
            -1
        } else {
            ans as i32
        }
    }
}

fn bisect_left(a: &[i32], x: i32) -> usize {
    let mut ng = -1;
    let mut ok = a.len() as i32;
    while (ok - ng).abs() > 1 {
        let mi = (ng + ok) / 2;
        if a[mi as usize] >= x {
            ok = mi;
        } else {
            ng = mi;
        }
    }
    ok as usize
}

struct Solution;

fn main() {
    println!("{}", Solution::take_characters("aabaaaacaabc".into(), 2));
    println!("{}", Solution::take_characters("a".into(), 1));
}
