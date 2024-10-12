impl Solution {
    pub fn min_groups(intervals: Vec<Vec<i32>>) -> i32 {
        let mut imos = vec![0; 1000000 + 2];
        for interval in intervals {
            let l = interval[0] as usize;
            let r = interval[1] as usize;
            imos[l] += 1;
            imos[r + 1] -= 1;
        }
        for i in 0..imos.len()-1 {
            imos[i + 1] += imos[i]
        }
        *imos.iter().max().unwrap()
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::min_groups(
            [[5, 10], [6, 8], [1, 5], [2, 3], [1, 10]]
                .map(Vec::from)
                .to_vec()
        ),
        3
    );
    assert_eq!(
        Solution::min_groups([[1, 3], [5, 6], [8, 10], [11, 13]].map(Vec::from).to_vec()),
        1
    );
}
