use std::collections::VecDeque;

impl Solution {
    pub fn find_min_height_trees(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        let n = n as usize;

        let mut graph = vec![vec![]; n];
        for edge in edges {
            let a = edge[0] as usize;
            let b = edge[1] as usize;
            graph[a].push(b);
            graph[b].push(a);
        }

        let path1 = Self::farest(n, &graph, 0);
        let path2 = Self::farest(n, &graph, path1[0]);

        let m = path2.len();
        if m % 2 == 0 {
            vec![path2[m / 2 - 1] as i32, path2[m / 2] as i32]
        } else {
            vec![path2[m / 2] as i32]
        }
    }

    /// startから最も遠い地点までのパスを求める
    pub fn farest(n: usize, graph: &Vec<Vec<usize>>, start: usize) -> Vec<usize> {
        let mut queue = VecDeque::new();
        let mut distance = vec![-1; n];
        let mut pre = (0..n).into_iter().collect::<Vec<_>>();

        queue.push_back(start);
        distance[start] = 0;

        while let Some(cur) = queue.pop_front() {
            for &nxt in &graph[cur] {
                if distance[nxt] == -1 {
                    distance[nxt] = distance[cur] + 1;
                    pre[nxt] = cur;
                    queue.push_back(nxt);
                }
            }
        }

        let mut path = vec![(0..n).max_by_key(|&i| distance[i]).unwrap()];
        while let Some(&cur) = path.last() {
            if cur == start {
                break;
            }
            path.push(pre[cur]);
        }

        path
    }
}

struct Solution;

fn main() {
    example1();
    example2();
}

fn example1() {
    let edges = [[1, 0], [1, 2], [1, 3]].map(|v| v.to_vec()).to_vec();
    println!("{:?}", Solution::find_min_height_trees(4, edges));
}

fn example2() {
    let edges = [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]
        .map(|v| v.to_vec())
        .to_vec();
    println!("{:?}", Solution::find_min_height_trees(6, edges));
}
