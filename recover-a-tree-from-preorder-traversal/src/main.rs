use std::cell::RefCell;
use std::rc::Rc;

use regex::Regex;
impl Solution {
    pub fn recover_from_preorder(traversal: String) -> Option<Rc<RefCell<TreeNode>>> {
        let path = Regex::new(r"(-*)([0-9]+)")
            .unwrap()
            .captures_iter(&traversal)
            .map(|c| c.extract())
            .map(|(_, [depth, val])| (depth.len(), val.parse::<i32>().unwrap()))
            .collect::<Vec<_>>();

        let (_, root_val) = path[0];
        let root = new_node(root_val);
        let mut stack = vec![(0, root.clone())];

        let mut i = 1;
        while let Some(&(nxt_lvl, nxt_val)) = path.get(i) {
            let (cur_lvl, cur_node) = stack.last().unwrap();
            if cur_lvl + 1 == nxt_lvl {
                let nxt_node = new_node(nxt_val);
                if cur_node.borrow().left.is_none() {
                    cur_node.borrow_mut().left = Some(nxt_node.clone());
                } else {
                    cur_node.borrow_mut().right = Some(nxt_node.clone());
                }
                stack.push((nxt_lvl, nxt_node));
                i += 1;
            } else {
                stack.pop();
            }
        }

        Some(root)
    }
}

fn new_node(val: i32) -> Rc<RefCell<TreeNode>> {
    Rc::new(RefCell::new(TreeNode::new(val)))
}

// ----------------------------------------
fn main() {
    println!(
        "{:?}",
        to_vec(Solution::recover_from_preorder(
            "1-2--3--4-5--6--7".to_string()
        ))
    );
    println!(
        "{:?}",
        to_vec(Solution::recover_from_preorder(
            "1-2--3---4-5--6---7".to_string()
        ))
    );
    println!(
        "{:?}",
        to_vec(Solution::recover_from_preorder(
            "1-401--349---90--88".to_string()
        ))
    );
}

fn to_vec(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
    let mut stack = vec![(0, root.unwrap().clone())];
    let mut vals = Vec::new();
    while let Some((index, parent)) = stack.pop() {
        while vals.len() <= index {
            vals.push(-1);
        }
        vals[index] = parent.borrow().val;

        if let Some(left) = &parent.borrow().left {
            stack.push((index * 2 + 1, left.clone()));
        }
        if let Some(right) = &parent.borrow().right {
            stack.push((index * 2 + 2, right.clone()));
        }
    }
    vals
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
