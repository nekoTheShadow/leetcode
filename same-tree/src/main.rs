use std::cell::RefCell;
use std::rc::Rc;
impl Solution {
    pub fn is_same_tree(
        p: Option<Rc<RefCell<TreeNode>>>,
        q: Option<Rc<RefCell<TreeNode>>>,
    ) -> bool {
        match (p, q) {
            (None, None) => true,
            (Some(p), Some(q)) => {
                p.borrow().val == q.borrow().val
                    && Self::is_same_tree(p.borrow().left.clone(), q.borrow().left.clone())
                    && Self::is_same_tree(p.borrow().right.clone(), q.borrow().right.clone())
            }
            _ => false,
        }
    }
}

fn main() {
    example1();
    example2();
}

fn example1() {
    let mut p = TreeNode::new(1);
    p.left = Some(Rc::new(RefCell::new(TreeNode::new(2))));
    p.right = Some(Rc::new(RefCell::new(TreeNode::new(3))));

    let mut q = TreeNode::new(1);
    q.left = Some(Rc::new(RefCell::new(TreeNode::new(2))));
    q.right = Some(Rc::new(RefCell::new(TreeNode::new(3))));

    println!(
        "{}",
        Solution::is_same_tree(
            Some(Rc::new(RefCell::new(p))),
            Some(Rc::new(RefCell::new(q)))
        )
    );
}

fn example2() {
    let mut p = TreeNode::new(1);
    p.left = Some(Rc::new(RefCell::new(TreeNode::new(2))));

    let mut q = TreeNode::new(1);
    q.right = Some(Rc::new(RefCell::new(TreeNode::new(2))));

    println!(
        "{}",
        Solution::is_same_tree(
            Some(Rc::new(RefCell::new(p))),
            Some(Rc::new(RefCell::new(q)))
        )
    );
}

pub struct Solution {}

// Definition for a binary tree node.
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
