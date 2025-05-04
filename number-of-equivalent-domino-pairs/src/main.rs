impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        let mut matrix = vec![vec![0; 10]; 10];
        let mut count = 0;
        for domino in dominoes {
            let a = std::cmp::min(domino[0], domino[1]) as usize;
            let b = std::cmp::max(domino[0], domino[1]) as usize;
            count += matrix[a][b];
            matrix[a][b] += 1;
        }
        count
    }
}

struct Solution;

fn main() {
    testing!([[1, 2], [2, 1], [3, 4], [5, 6]], 1);
    testing!([[1, 2], [1, 2], [1, 1], [1, 2], [2, 2]], 3);
}

#[macro_export]
macro_rules! testing {
    ($dominoes: expr, $output: expr) => {
        assert_eq!(
            Solution::num_equiv_domino_pairs($dominoes.map(|domino| domino.to_vec()).to_vec()),
            $output
        );
    };
}
