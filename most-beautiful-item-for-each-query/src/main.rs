impl Solution {
    pub fn maximum_beauty(items: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        let mut items = items;
        items.sort_by_key(|item| (item[0], -item[1]));
        for i in 1..items.len() {
            items[i][1] = std::cmp::max(items[i][1], items[i - 1][1]);
        }

        let mut answers = Vec::new();
        let n = items.len() as i32;
        for query in queries {
            let mut ok = -1;
            let mut ng = n;
            while (ok - ng).abs() > 1 {
                let mi = (ok + ng) / 2;
                if items[mi as usize][0] <= query {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }

            if 0 <= ok {
                answers.push(items[ok as usize][1]);
            } else {
                answers.push(0);
            }
        }

        answers
    }
}

struct Solution;

fn main() {
    assert_eq!(
        Solution::maximum_beauty(
            [[1, 2], [3, 2], [2, 4], [5, 6], [3, 5]]
                .map(|item| item.to_vec())
                .to_vec(),
            vec![1, 2, 3, 4, 5, 6]
        ),
        vec![2, 4, 5, 5, 6, 6]
    );
    assert_eq!(
        Solution::maximum_beauty(
            [[1, 2], [1, 2], [1, 3], [1, 4]]
                .map(|item| item.to_vec())
                .to_vec(),
            vec![1]
        ),
        vec![4]
    );
    assert_eq!(
        Solution::maximum_beauty([[10, 1000]].map(|item| item.to_vec()).to_vec(), vec![5]),
        vec![0]
    );
}
