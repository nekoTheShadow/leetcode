impl Solution {
    pub fn find_the_winner(n: i32, k: i32) -> i32 {
        let mut a = (1..=n).collect::<Vec<_>>();
        
        let k = k as usize;
        let mut i = 0 as usize;
        while a.len() > 1 {
            i = (i + k - 1) % a.len();
            a.remove(i);
            i %= a.len();
        }

        a[0]
    }
}

struct Solution;


fn main() {
    assert_eq!(Solution::find_the_winner(5, 2), 3);
    assert_eq!(Solution::find_the_winner(6, 5), 1);
}
