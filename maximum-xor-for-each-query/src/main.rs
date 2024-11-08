impl Solution {
    pub fn get_maximum_xor(nums: Vec<i32>, maximum_bit: i32) -> Vec<i32> {
        let maximum_bit = maximum_bit as usize;
        let n = 30;

        let mut counter = vec![0; n];
        for num in &nums {
            for i in 0..n {
                counter[i] += (num >> i) & 1;
            }
        }
        
        let mut ret = Vec::new();
        for num in nums.iter().rev() {
            let k = (0..maximum_bit)
                .filter(|&i| counter[i] % 2 == 0)
                .fold(0, |acc, i| acc | (1 << i));
            ret.push(k);
            for i in 0..n {
                counter[i] -= (num >> i) & 1;
            }
        }

        ret
    }
}
struct Solution;

fn main() {
    assert_eq!(
        Solution::get_maximum_xor(vec![0, 1, 1, 3], 2),
        vec![0, 3, 2, 3]
    );
    assert_eq!(
        Solution::get_maximum_xor(vec![2, 3, 4, 7], 3),
        vec![5, 2, 6, 5]
    );
    assert_eq!(
        Solution::get_maximum_xor(vec![0, 1, 2, 2, 5, 7], 3),
        vec![4, 3, 6, 4, 6, 7]
    );
}
