impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        let blocks = blocks.chars().collect::<Vec<_>>();
        let k = k as usize;

        let mut white = (0..k - 1).filter(|i| blocks[*i] == 'W').count();
        let mut min = std::usize::MAX;
        for i in k - 1..blocks.len() {
            if blocks[i] == 'W' {
                white += 1;
            }
            min = std::cmp::min(min, white);
            if blocks[i + 1 - k] == 'W' {
                white -= 1;
            }
        }

        min as i32
    }
}

struct Solution;

fn main() {
    assert_eq!(Solution::minimum_recolors("WBBWWBBWBW".to_string(), 7), 3);
    assert_eq!(Solution::minimum_recolors("WBWBBBW".to_string(), 2), 0);
}
