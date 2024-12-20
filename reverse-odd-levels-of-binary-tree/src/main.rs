use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn reverse_odd_levels(
        root: Option<Rc<RefCell<TreeNode>>>,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        if root.is_none() {
            return root;
        }

        let mut nodes = vec![root.clone().unwrap()];
        let mut lvl = 0;
        while !nodes.is_empty() {
            let n = nodes.len();

            if lvl % 2 == 1 {
                let mut i = 0;
                let mut j = n - 1;
                while i < j {
                    let v1 = nodes[i].borrow().val;
                    let v2 = nodes[j].borrow().val;
                    nodes[i].borrow_mut().val = v2;
                    nodes[j].borrow_mut().val = v1;
                    i += 1;
                    j -= 1;
                }
            }

            let mut next_nodes = Vec::new();
            for i in 0..n {
                if let Some(left) = nodes[i].borrow().left.clone() {
                    next_nodes.push(left);
                }
                if let Some(right) = nodes[i].borrow().right.clone() {
                    next_nodes.push(right);
                }
            }

            lvl += 1;
            nodes = next_nodes;
        }

        root
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

fn main() {
    println!("hello")
}
