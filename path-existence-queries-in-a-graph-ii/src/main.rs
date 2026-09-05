impl Solution {
    pub fn path_existence_queries(
        n: i32,
        nums: Vec<i32>,
        max_diff: i32,
        queries: Vec<Vec<i32>>,
    ) -> Vec<i32> {
        let n = n as usize;

        // (value, original index)
        let mut pairs = Vec::new();
        for (i, &x) in nums.iter().enumerate() {
            pairs.push((x, i));
        }
        pairs.sort_unstable();

        const LOG: usize = 20;
        let mut up = vec![vec![0; LOG]; n];

        let mut r = n - 1;

        // 値の降順で構築
        for l in (0..n).rev() {
            while pairs[r].0 - pairs[l].0 > max_diff {
                r -= 1;
            }

            let from = pairs[l].1;
            let to = pairs[r].1;

            up[from][0] = to;

            for k in 1..LOG {
                up[from][k] = up[up[from][k - 1]][k - 1];
            }
        }

        let mut ans = Vec::new();

        for q in queries {
            let mut u = q[0] as usize;
            let mut v = q[1] as usize;

            // 常に小さい値 → 大きい値
            if nums[u] > nums[v] {
                std::mem::swap(&mut u, &mut v);
            }

            if u == v {
                ans.push(0);
                continue;
            }

            if nums[u] == nums[v] {
                ans.push(1);
                continue;
            }

            let mut dist = 0;

            for k in (0..LOG).rev() {
                if nums[up[u][k]] < nums[v] {
                    u = up[u][k];
                    dist |= 1 << k;
                }
            }

            if nums[up[u][0]] < nums[v] {
                ans.push(-1);
            } else {
                ans.push(dist + 1);
            }
        }

        ans
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let n = 5;
        let nums = [1, 8, 3, 4, 2];
        let max_diff = 3;
        let queries = [[0, 3], [2, 4]];
        let output = [1, 1];
        assert_eq!(
            Solution::path_existence_queries(
                n,
                nums.to_vec(),
                max_diff,
                queries.map(|query| query.to_vec()).to_vec()
            ),
            output.to_vec()
        );
    }

    #[test]
    fn example2() {
        let n = 5;
        let nums = [5, 3, 1, 9, 10];
        let max_diff = 2;
        let queries = [[0, 1], [0, 2], [2, 3], [4, 3]];
        let output = [1, 2, -1, 1];
        assert_eq!(
            Solution::path_existence_queries(
                n,
                nums.to_vec(),
                max_diff,
                queries.map(|query| query.to_vec()).to_vec()
            ),
            output.to_vec()
        );
    }

    #[test]
    fn example3() {
        let n = 3;
        let nums = [3, 6, 1];
        let max_diff = 1;
        let queries = [[0, 0], [0, 1], [1, 2]];
        let output = [0, -1, -1];
        assert_eq!(
            Solution::path_existence_queries(
                n,
                nums.to_vec(),
                max_diff,
                queries.map(|query| query.to_vec()).to_vec()
            ),
            output.to_vec()
        );
    }
}
