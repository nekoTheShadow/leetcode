use std::collections::HashSet;

impl Solution {
    pub fn num_tile_possibilities(tiles: String) -> i32 {
        let mut set = HashSet::new();
        dfs(
            &tiles.chars().collect(),
            &mut String::from(""),
            &mut vec![false; tiles.len()],
            &mut set,
        );
        set.len() as i32
    }
}

fn dfs(tiles: &Vec<char>, buf: &mut String, visited: &mut Vec<bool>, set: &mut HashSet<String>) {
    if buf != "" {
        set.insert(buf.to_string());
    }

    for i in 0..tiles.len() {
        if !visited[i] {
            buf.push(tiles[i]);
            visited[i] = true;
            dfs(tiles, buf, visited, set);
            buf.pop();
            visited[i] = false;
        }
    }
}


struct Solution;


fn main() {
    assert_eq!(Solution::num_tile_possibilities("AAB".to_string()), 8);
    assert_eq!(Solution::num_tile_possibilities("AAABBC".to_string()), 188);
    assert_eq!(Solution::num_tile_possibilities("V".to_string()), 1);
}
