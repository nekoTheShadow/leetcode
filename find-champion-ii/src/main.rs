impl Solution {
    pub fn find_champion(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        let n = n as usize;
        let mut d = vec![0; n];
        for edge in edges {
            d[edge[1] as usize] += 1;
        }

        let ans = (0..n).filter(|i| d[*i] == 0).collect::<Vec<_>>();
        if ans.len() == 1 {
            ans[0] as i32
        } else {
            -1
        }
    }
}

struct Solution;

fn main() {
    let edges = [[0, 1], [1, 2]].map(|edge| edge.to_vec()).to_vec();
    assert_eq!(Solution::find_champion(3, edges), 0);

    let edges = [[0, 2], [1, 3], [1, 2]].map(|edge| edge.to_vec()).to_vec();
    assert_eq!(Solution::find_champion(4, edges), -1);
}
