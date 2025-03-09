impl Solution {
    pub fn number_of_alternating_groups(colors: Vec<i32>, k: i32) -> i32 {
        let k = k as usize;
        let n = colors.len();

        let mut same = (0..k - 2).filter(|&i| colors[i] == colors[i + 1]).count();
        let mut ret = 0;
        let mut head = 0;
        let mut tail = k - 1;
        
        for _ in 0..n {
            if colors[pre(tail, n)] == colors[tail] {
                same += 1;
            }
            tail = nxt(tail, n);

            if same == 0 {
                ret += 1;
            }

            if colors[head] == colors[nxt(head, n)] {
                same -= 1;
            }
            head = nxt(head, n);
        }

        ret
    }
}

fn pre(x: usize, n: usize) -> usize {
    (n + x - 1) % n
}

fn nxt(x: usize, n: usize) -> usize {
    (x + 1) % n
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::number_of_alternating_groups(vec![0, 1, 0, 1, 0], 3),
        3
    );
    assert_eq!(
        Solution::number_of_alternating_groups(vec![0, 1, 0, 0, 1, 0, 1], 6),
        2
    );
    assert_eq!(
        Solution::number_of_alternating_groups(vec![1, 1, 0, 1], 4),
        0
    );
}
