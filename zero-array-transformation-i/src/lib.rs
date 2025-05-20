impl Solution {
    pub fn is_zero_array(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> bool {
        let n = nums.len();

        let mut imos = vec![0; n + 1];
        for query in queries {
            let l = query[0] as usize;
            let r = query[1] as usize;
            imos[l] += 1;
            imos[r + 1] -= 1;
        }

        for i in 0..n {
            imos[i + 1] += imos[i]
        }
        (0..n).all(|i| nums[i] <= imos[i])
    }
}

struct Solution;

pub fn add(left: u64, right: u64) -> u64 {
    left + right
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        assert_eq!(
            Solution::is_zero_array(vec![1, 0, 1], [[0, 2]].map(|a| a.to_vec()).to_vec()),
            true
        )
    }

    #[test]
    fn example2() {
        assert_eq!(
            Solution::is_zero_array(
                vec![4, 3, 2, 1],
                [[1, 3], [0, 2]].map(|a| a.to_vec()).to_vec()
            ),
            false
        )
    }
}
