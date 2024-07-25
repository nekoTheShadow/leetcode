impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        let mut tpls = nums
            .iter()
            .enumerate()
            .map(|(index, num)| {
                if *num == 0 {
                    return (mapping[0], index, num);
                }

                let mut a = *num;
                let mut b = 0;
                let mut c = 1;
                while a > 0 {
                    b = mapping[(a % 10) as usize] * c + b;
                    a /= 10;
                    c *= 10;
                }
                (b, index, num)
            })
            .collect::<Vec<_>>();
        tpls.sort();
        tpls.iter().map(|(_b, _index, num)| **num).collect()
    }
}

struct Solution;

fn main() {
    println!(
        "{:?}",
        Solution::sort_jumbled(vec![8, 9, 4, 0, 2, 1, 3, 5, 7, 6], vec![991, 338, 38])
    );
    println!(
        "{:?}",
        Solution::sort_jumbled(vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9], vec![789, 456, 123])
    );
}
