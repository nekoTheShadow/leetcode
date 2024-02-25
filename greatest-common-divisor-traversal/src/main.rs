struct UnionFind {
    parent: Vec<usize>
}

impl UnionFind {
    pub fn new(size: usize) -> Self{
        UnionFind { parent: (0..size).collect() }
    }

    pub fn find(&mut self, x: usize) -> usize {
        if self.parent[x] == x {
            return x;
        }
        self.parent[x] = self.find(self.parent[x]);
        self.parent[x]
    }

    pub fn union(&mut self, x:usize, y: usize) {
        let x = self.find(x);
        let y = self.find(y);
        if x != y {
            self.parent[x] = y;
        }
    }
}

impl Solution {
    pub fn can_traverse_all_pairs(nums: Vec<i32>) -> bool {
        if nums.len() == 1 {
            return true
        }
        if nums.contains(&1) {
            return false
        }

        let nums = nums.iter().map(|&num| num as usize).collect::<Vec<_>>();

        let mut uf = UnionFind::new(10_usize.pow(5)+1);
        for &num in &nums {
            for (factor, _) in Self::factorization(num) {
                uf.union(num, factor);
            }
        }


        nums.iter().all(|&num| uf.find(nums[0]) == uf.find(num))
    }

    fn factorization(n: usize) -> Vec<(usize, usize)> {
        let mut n = n;
        let mut res = vec![];
        for p in 2..n {
            if p*p > n {
                break
            }
            if n%p != 0 {
                continue
            }
            let mut e = 0;
            while n%p == 0 {
                e += 1;
                n /= p;
            }
            res.push((p, e))
        }

        if n != 1 {
            res.push((n, 1))
        }
        res
    }
}




struct Solution {}


fn main() {
    println!("{}",Solution::can_traverse_all_pairs(vec![2,3,6]));
    println!("{}",Solution::can_traverse_all_pairs(vec![3,9,5]));
    println!("{}",Solution::can_traverse_all_pairs(vec![4,3,12,8]));
}
