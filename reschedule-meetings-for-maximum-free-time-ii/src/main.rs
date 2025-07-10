use std::collections::BTreeMap;

impl Solution {
    pub fn max_free_time(event_time: i32, start_time: Vec<i32>, end_time: Vec<i32>) -> i32 {
        let mut meetings = Vec::new();
        meetings.push((-1, 0));
        for (s, e) in start_time.iter().zip(end_time.iter()) {
            meetings.push((*s, *e));
        }
        meetings.push((event_time, -1));

        let mut map = BTreeMap::new();
        for m in meetings.windows(2) {
            let (_s1, e1) = m[0];
            let (s2, _e2) = m[1];
            push(&mut map, s2 - e1);
        }

        let mut ans = 0;
        for i in 1..meetings.len() - 1 {
            let (_s0, e0) = meetings[i - 1];
            let (s1, e1) = meetings[i];
            let (s2, _e2) = meetings[i + 1];

            // 前or後に動かす場合
            ans = std::cmp::max(ans, (s1 - e0) + (s2 - e1));

            remove(&mut map, s1 - e0);
            remove(&mut map, s2 - e1);
            if check(&mut map, e1 - s1) {
                ans = std::cmp::max(ans, (s1 - e0) + (s2 - e1) + (e1 - s1));
            }
            push(&mut map, s1 - e0);
            push(&mut map, s2 - e1);
        }

        ans
    }
}

fn push(map: &mut BTreeMap<i32, usize>, v: i32) {
    *map.entry(v).or_insert(0) += 1;
}

fn remove(map: &mut BTreeMap<i32, usize>, v: i32) {
    if map[&v] == 1 {
        map.remove(&v);
    } else {
        *map.get_mut(&v).unwrap() -= 1;
    }
}

fn check(map: &mut BTreeMap<i32, usize>, v: i32) -> bool {
    if let Some((&max, _)) = map.last_key_value() {
        v <= max
    } else {
        false
    }
}
struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_example1() {
        let event_time = 5;
        let start_time = vec![1, 3];
        let end_time = vec![2, 5];
        let result = Solution::max_free_time(event_time, start_time, end_time);
        assert_eq!(result, 2);
    }

    #[test]
    fn test_example2() {
        let event_time = 10;
        let start_time = vec![0, 7, 9];
        let end_time = vec![1, 8, 10];
        let result = Solution::max_free_time(event_time, start_time, end_time);
        assert_eq!(result, 7);
    }

    #[test]
    fn test_example3() {
        let event_time = 10;
        let start_time = vec![0, 3, 7, 9];
        let end_time = vec![1, 4, 8, 10];
        let result = Solution::max_free_time(event_time, start_time, end_time);
        assert_eq!(result, 6);
    }

    #[test]
    fn test_example4() {
        let event_time = 5;
        let start_time = vec![0, 1, 2, 3, 4];
        let end_time = vec![1, 2, 3, 4, 5];
        let result = Solution::max_free_time(event_time, start_time, end_time);
        assert_eq!(result, 0);
    }
}
