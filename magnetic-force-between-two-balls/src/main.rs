impl Solution {
    pub fn max_distance(position: Vec<i32>, m: i32) -> i32 {
        let mut position = position;
        position.sort();

        let check = |mi: i32| -> bool {
            let mut last = position[0];
            let mut count = 1;
            for &p in &position {
                if mi <= p - last {
                    last = p;
                    count += 1;
                }
            }
            m <= count
        };

        let mut ng = i32::MAX / 2 - 1;
        let mut ok = 0;
        while (ok - ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if check(mi) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        ok
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::max_distance(vec![1, 2, 3, 4, 7], 3));
    println!(
        "{}",
        Solution::max_distance(vec![5, 4, 3, 2, 1, 1000000000], 2)
    );
}
