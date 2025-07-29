use std::collections::HashMap;

impl Solution {
    pub fn delete_duplicate_folder(paths: Vec<Vec<String>>) -> Vec<Vec<String>> {
        let mut root = Trie::new();
        for path in paths {
            let mut cur = &mut root;
            for node in path {
                cur = cur.children.entry(node).or_insert(Trie::new());
            }
        }

        let mut freq = HashMap::new();
        construct(&mut root, &mut freq);

        let mut ans = Vec::new();
        let mut path = Vec::new();
        operate(&root, &freq, &mut path, &mut ans);

        ans
    }
}

fn construct(node: &mut Trie, freq: &mut HashMap<String, i32>) {
    if node.children.is_empty() {
        return;
    }

    let mut tokens = Vec::new();
    for (folder, child) in node.children.iter_mut() {
        construct(child, freq);
        tokens.push(format!("{}({})", folder, child.serial));
    }

    tokens.sort();
    node.serial = tokens.join("");
    *freq.entry(node.serial.clone()).or_insert(0) += 1;
}

fn operate(
    node: &Trie,
    freq: &HashMap<String, i32>,
    path: &mut Vec<String>,
    ans: &mut Vec<Vec<String>>,
) {
    if let Some(count) = freq.get(&node.serial)
        && *count > 1
    {
        return;
    }

    if !path.is_empty() {
        ans.push(path.clone());
    }

    for (folder, child) in &node.children {
        path.push(folder.clone());
        operate(child, freq, path, ans);
        path.pop();
    }
}

#[derive(Debug)]
struct Trie {
    serial: String,
    children: HashMap<String, Trie>,
}

impl Trie {
    fn new() -> Self {
        Self {
            serial: String::new(),
            children: HashMap::new(),
        }
    }
}

struct Solution;

fn main() {
    let paths = to_path!([["a"], ["c"], ["d"], ["a", "b"], ["c", "b"], ["d", "a"]]);
    let output = to_path!([["d"], ["d", "a"]]);
    assert_eq!(Solution::delete_duplicate_folder(paths), output);

    let paths = to_path!([["a"], ["c"], ["d"], ["a", "b"], ["c", "b"], ["d", "a"]]);
    let output = to_path!([["d"], ["d", "a"]]);
    assert_eq!(Solution::delete_duplicate_folder(paths), output);
}

#[macro_export]
macro_rules! to_path {
    ( [ $( [ $( $x:expr ),* ] ),* ] ) => {
        vec![
            $( vec![ $( $x.to_string() ),* ] ),*
        ]
    };
}
