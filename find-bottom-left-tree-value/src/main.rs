use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn find_bottom_left_value(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut ret_val = root.clone().unwrap().borrow().val;
        let mut ret_depth = 0;
        Self::dfs(&root, 0, &mut ret_val, &mut ret_depth);
        ret_val
    }

    fn dfs(
        cur: &Option<Rc<RefCell<TreeNode>>>,
        cur_depth: u128,
        ret_val: &mut i32,
        ret_depth: &mut u128,
    ) {
        if cur.is_none() {
            return;
        }
        if *ret_depth < cur_depth {
            *ret_val = cur.clone().unwrap().borrow().val;
            *ret_depth = cur_depth;
        }
        Self::dfs(
            &cur.clone().unwrap().borrow().left,
            cur_depth + 1,
            ret_val,
            ret_depth,
        );
        Self::dfs(
            &cur.clone().unwrap().borrow().right,
            cur_depth + 1,
            ret_val,
            ret_depth,
        );
    }
}

fn main() {
    println!(
        "{}",
        Solution::find_bottom_left_value(build_tree(vec![1, 2, 3, 4, -1, 5, 6, -1, -1, -1, -1, 7]))
    );
}

fn build_tree(vals: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
    let nodes = vals
        .iter()
        .map(|&val| {
            if val == -1 {
                None
            } else {
                Some(Rc::new(RefCell::new(TreeNode::new(val))))
            }
        })
        .collect::<Vec<_>>();
    for i in 0..vals.len() {
        if nodes[i].is_none() {
            continue;
        }
        if i * 2 + 1 < vals.len() {
            nodes[i].clone().unwrap().borrow_mut().left = nodes[i * 2 + 1].clone()
        }
        if i * 2 + 2 < vals.len() {
            nodes[i].clone().unwrap().borrow_mut().right = nodes[i * 2 + 2].clone()
        }
    }
    nodes[0].clone()
}

struct Solution {}

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
