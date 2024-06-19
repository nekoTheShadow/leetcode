impl Solution {

    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        let inf = i32::MAX/2-1;

        let check = |mi: i32| -> bool {
            let mut streak = 0;
            let mut count = 0;
            for &d in &bloom_day {
                if d <= mi {
                    streak += 1;
                } else {
                    streak = 0;
                }
    
                if streak == k {
                    count += 1;
                    streak = 0;
                }
            }
    
            m <= count
        };

        let mut ok = inf;
        let mut ng = 0_i32;
        while (ok-ng).abs() > 1 {
            let mi = (ok + ng) / 2;
            if check(mi) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        
        if ok == inf {
            -1
        } else {
            ok
        }
    }
}

struct Solution;


fn main() {
    println!("{}", Solution::min_days(vec![1,10,3,10,2], 3, 1));
    println!("{}", Solution::min_days(vec![1,10,3,10,2], 3, 2));
    println!("{}", Solution::min_days(vec![7,7,7,7,12,7,7], 2, 3));

    println!("{}", Solution::min_days(vec![79,30,15,94,80,52,14,4,81,62,40,47,44,98,73,63,36,1,66,83,66,36,35,64,45,21,76,4,79,36,57,20,86,15,19], 35, 1));
}
