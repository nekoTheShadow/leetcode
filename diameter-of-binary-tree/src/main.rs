use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn diameter_of_binary_tree(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut ret = 0;
        Self::max_depth(&root, &mut ret);
        ret
    }

    fn max_depth(root: &Option<Rc<RefCell<TreeNode>>>, ret: &mut i32) -> i32 {
        match root {
            None => 0,
            Some(root) => {
                let l = Self::max_depth(&root.borrow().left, ret);
                let r = Self::max_depth(&root.borrow().right, ret);
                *ret = std::cmp::max(*ret, l + r);
                l.max(r) + 1
            }
        }
    }
}

fn main() {
    println!(
        "{:?}",
        Solution::diameter_of_binary_tree(build_tree(vec![1, 2, 3, 4, 5]))
    );
    println!(
        "{:?}",
        Solution::diameter_of_binary_tree(build_tree(vec![1, 2]))
    );
}

fn build_tree(vals: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
    let nodes = vals
        .iter()
        .map(|&val| Rc::new(RefCell::new(TreeNode::new(val))))
        .collect::<Vec<_>>();
    for i in 0..vals.len() {
        if i * 2 + 1 < vals.len() {
            nodes[i].borrow_mut().left = Some(nodes[i * 2 + 1].clone());
        }
        if i * 2 + 2 < vals.len() {
            nodes[i].borrow_mut().right = Some(nodes[i * 2 + 2].clone());
        }
    }
    Some(nodes[0].clone())
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
