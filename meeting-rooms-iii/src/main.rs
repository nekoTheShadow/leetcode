use std::cmp::Reverse;

impl Solution {
    pub fn most_booked(n: i32, meetings: Vec<Vec<i32>>) -> i32 {
        let n = n as usize;
        let mut meetings = meetings;
        meetings.sort_unstable_by_key(|meeting| meeting[0]);

        let mut reserves = vec![0i128; n];
        let mut counter = vec![0i128; n];

        for meeting in meetings {
            let s1 = meeting[0] as i128;
            let e1 = meeting[1] as i128;

            // 空室があれば、その部屋を使う。
            // 空室が複数ある場合は、番号がもっとも若いものを使う。
            if let Some(room) = (0..n).filter(|&i| reserves[i] <= s1).min() {
                reserves[room] = e1;
                counter[room] += 1;
            } else {
                // 空室がない場合は、一番最初に空室になる部屋を使う。
                // そのような部屋が複数ある場合は、番号がもっとも若いものを使う。
                let room = (0..n).min_by_key(|&i| (reserves[i], i)).unwrap();
                reserves[room] = reserves[room] + (e1-s1);
                counter[room] += 1;
            }
        }
        
        // 会議の使用回数が多い部屋を選択する。
        // そのような部屋が複数ある場合は、番号がもっとも若いものを使う。
        (0..n).max_by_key(|&i| (counter[i], Reverse(i))).unwrap() as i32
    }
}


struct Solution {}

fn main() {
    println!("{}", Solution::most_booked(2, [[0,10],[1,5],[2,7],[3,4]].iter().map(|slice| slice.to_vec()).collect::<Vec<_>>())); //=> 0
    println!("{}", Solution::most_booked(3, [[1,20],[2,10],[3,5],[4,9],[6,8]].iter().map(|slice| slice.to_vec()).collect::<Vec<_>>())); //=> 1
}


