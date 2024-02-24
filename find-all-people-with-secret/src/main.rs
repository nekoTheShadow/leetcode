use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn find_all_people(n: i32, meetings: Vec<Vec<i32>>, first_person: i32) -> Vec<i32> {
        let n = n as usize;
        let first_person = first_person as usize;

        let mut secret = vec![i32::MAX; n];
        secret[0] = 0;
        secret[first_person] = 0;

        let mut g1 = HashMap::new();
        for meeting in meetings {
            let x = meeting[0] as usize;
            let y = meeting[1] as usize;
            let t = meeting[2];
            g1.entry(t).or_insert(vec![]).push((x, y));
        }

        let mut g2 = HashMap::new();
        for (t, tpls) in g1 {
            let mut set = HashSet::new();
            let mut uf = UnionFind::new(n);
            for (x, y) in tpls {
                uf.union(x, y);
                set.insert(x);
                set.insert(y);
            }
            for x in set {
                g2.entry((t, uf.find(x))).or_insert(vec![]).push(x);
            }
        }

        let mut g3 = g2.iter().map(|((t, _), users)| (t, users)).collect::<Vec<_>>();
        g3.sort_unstable_by_key(|(t, _)| **t);
        for (t, users) in g3 {
            if users.iter().any(|user| secret[*user] <= *t) {
                for user in users {
                    secret[*user] = secret[*user].min(*t);
                }
            }
        }

        (0..n).filter_map(|i| if secret[i] == i32::MAX { None } else { Some(i as i32) }).collect::<Vec<_>>()
    }
}


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

struct Solution {}

fn main() {
    println!("{:?}", Solution::find_all_people(6, vec![vec![1,2,5],vec![2,3,8],vec![1,5,10]], 1));
    println!("{:?}", Solution::find_all_people(4, vec![vec![3,1,3],vec![1,2,2],vec![0,3,3]], 3));
    println!("{:?}", Solution::find_all_people(5, vec![vec![3,4,2],vec![1,2,1],vec![2,3,1]], 1));
}
