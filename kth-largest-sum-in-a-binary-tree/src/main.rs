use std::cell::RefCell;
use std::cmp::Reverse;
use std::collections::HashMap;
use std::rc::Rc;

impl Solution {
    pub fn kth_largest_level_sum(root: Option<Rc<RefCell<TreeNode>>>, k: i32) -> i64 {
        let mut map = HashMap::new();
        Self::dfs(&root, 0, &mut map);

        let mut totals = map.values().collect::<Vec<_>>();
        totals.sort_by_key(|total| Reverse(**total));

        let n = (k - 1) as usize;
        if n < totals.len() {
            *totals[n]
        } else {
            -1
        }
    }

    pub fn dfs(root: &Option<Rc<RefCell<TreeNode>>>, level: usize, map: &mut HashMap<usize, i64>) {
        if let Some(node) = root {
            if let Some(v) = map.get_mut(&level) {
                *v += node.borrow().val as i64;
            } else {
                map.insert(level, node.borrow().val as i64);
            }

            Self::dfs(&node.borrow().left, level + 1, map);
            Self::dfs(&node.borrow().right, level + 1, map);
        }
    }
}

struct Solution;

#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

fn to_tree(vals: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
    fn build_tree(vals: &Vec<i32>, index: usize) -> Option<Rc<RefCell<TreeNode>>> {
        if vals.len() <= index || vals[index] == -1 {
            return None;
        }

        let node = Rc::new(RefCell::new(TreeNode {
            val: vals[index],
            left: build_tree(vals, 2 * index + 1),
            right: build_tree(vals, 2 * index + 2),
        }));
        Some(node)
    }
    build_tree(&vals, 0)
}

fn main() {
    assert_eq!(
        Solution::kth_largest_level_sum(to_tree(vec![5, 8, 9, 2, 1, 3, 7, 4, 6]), 2),
        13
    );
    assert_eq!(
        Solution::kth_largest_level_sum(to_tree(vec![1, 2, -1, 3]), 1),
        3
    );
    assert_eq!(
        Solution::kth_largest_level_sum(to_tree(vec![5, 8, 9, 2, 1, 3, 7]), 4),
        -1
    );
}
