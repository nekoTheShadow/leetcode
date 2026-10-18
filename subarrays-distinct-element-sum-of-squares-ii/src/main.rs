use std::collections::HashMap;

struct BIT {
    size: usize,
    tree1: Vec<i64>,
    tree2: Vec<i64>,
}

impl BIT {
    fn new(n: usize) -> Self {
        Self {
            size: n,
            tree1: vec![0; n + 2],
            tree2: vec![0; n + 2],
        }
    }

    // 内部のロビット計算
    fn lowbit(index: usize) -> usize {
        index & index.wrapping_neg()
    }

    // 指定した1点に対する加算処理のヘルパー
    fn update_point(&mut self, mut index: usize, delta: i64) {
        let raw_index = index as i64;
        while index <= self.size {
            self.tree1[index] += delta;
            self.tree2[index] += raw_index * delta;
            index += Self::lowbit(index);
        }
    }

    // 範囲 [left, right] に delta を加算する（1-based インデックス）
    fn add(&mut self, left: usize, right: usize, delta: i64) {
        self.update_point(left, delta);
        self.update_point(right + 1, -delta);
    }

    // プレフィックス（1からindexまで）のクエリ計算
    fn prefix_query(&self, mut index: usize) -> i64 {
        let original_index = index as i64;
        let mut sum1 = 0;
        let mut sum2 = 0;
        while index > 0 {
            sum1 += self.tree1[index];
            sum2 += self.tree2[index];
            index -= Self::lowbit(index);
        }
        sum1 * (original_index + 1) - sum2
    }

    // 範囲 [left, right] のクエリを取得する
    fn query(&self, left: usize, right: usize) -> i64 {
        self.prefix_query(right) - self.prefix_query(left - 1)
    }
}

impl Solution {
    pub fn sum_counts(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mod_val = 1_000_000_007;
        let mut bit = BIT::new(n + 2);
        let mut seen = HashMap::new();
        
        let mut res = 0;
        let mut cur = 0;

        for (i, &a) in nums.iter().enumerate() {
            // 0-based インデックスでの前回出現位置の次
            let j = seen.get(&a).map_or(0, |&prev| prev + 1);
            
            // BIT用の 1-based インデックスに変換
            let l = j + 1;
            let r = i + 1;

            // 範囲 [l, r] のクエリを取得
            let q = bit.query(l, r);

            // 変化量を計算して cur に加算
            let num_elements = (i - j + 1) as i64;
            cur = (cur + q * 2 + num_elements) % mod_val;
            res = (res + cur) % mod_val;

            // BITの範囲 [l, r] に 1 を加算
            bit.add(l, r, 1);
            seen.insert(a, i);
        }

        ((res + mod_val) % mod_val) as i32
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}
