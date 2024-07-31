use std::collections::HashMap;

impl Solution {
    pub fn min_height_shelves(books: Vec<Vec<i32>>, shelf_width: i32) -> i32 {
        return Self::dp(&mut HashMap::new(), &books, shelf_width, 0, 0, shelf_width);
    }

    pub fn dp(
        memo: &mut HashMap<(usize, i32, i32), i32>,
        books: &[Vec<i32>],
        shelf_width: i32,
        cur: usize,
        h: i32,
        w: i32,
    ) -> i32 {
        if books.len() == cur {
            return h;
        }

        let key = (cur, h, w);
        if let Some(&v) = memo.get(&key) {
            return v;
        }

        let thickness = books[cur][0];
        let height = books[cur][1];

        let mut ret = std::i32::MAX;

        // 同じ段に置く
        if thickness <= w {
            let v = Self::dp(
                memo,
                books,
                shelf_width,
                cur + 1,
                std::cmp::max(height, h),
                w - thickness,
            );
            ret = std::cmp::min(ret, v);
        }

        // 別の段に置く
        if w != shelf_width {
            let v = Self::dp(memo, books, shelf_width, cur, 0, shelf_width) + h;
            ret = std::cmp::min(ret, v);
        }

        memo.insert(key, ret);
        return ret;
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::min_height_shelves(
            [[1, 1], [2, 3], [2, 3], [1, 1], [1, 1], [1, 1], [1, 2]]
                .map(|a| a.to_vec())
                .to_vec(),
            4
        )
    );
    println!(
        "{}",
        Solution::min_height_shelves([[1, 3], [2, 4], [3, 2]].map(|a| a.to_vec()).to_vec(), 6)
    );
}
