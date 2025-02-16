impl Solution {
    pub fn construct_distanced_sequence(n: i32) -> Vec<i32> {
        let mut a = vec![0; (n * 2 - 1) as usize];
        construct(&mut a);
        a.iter().map(|&v| v as i32).collect()
    }
}

fn construct(a: &mut Vec<usize>) -> bool {
    let m = a.len();
    let n = (m + 1) / 2;

    let index = a.iter().position(|&v| v == 0);
    if index.is_none() {
        return true;
    }

    let i = index.unwrap();
    for v in (1..=n).rev() {
        if a.contains(&v) {
            continue;
        }

        if v == 1 {
            a[i] = v;
            if construct(a) {
                return true;
            }
            a[i] = 0;
        } else {
            let j = i + v;
            if j < m && a[j] == 0 {
                a[i] = v;
                a[j] = v;
                if construct(a) {
                    return true;
                }
                a[i] = 0;
                a[j] = 0;
            }
        }
    }

    false
}
struct Solution;

fn main() {
    println!("{:?}", Solution::construct_distanced_sequence(3));
    println!("{:?}", Solution::construct_distanced_sequence(5));
}
