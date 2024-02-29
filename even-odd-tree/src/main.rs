use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;
impl Solution {
    pub fn is_even_odd_tree(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        let mut q = VecDeque::new();
        q.push_back((root, 0));
        let mut last_level = -1;
        let mut last_val = -1;
        while !q.is_empty() {
            let (node, level) = q.pop_front().unwrap();
            if node.is_none() {
                continue;
            }
            let val = node.clone().unwrap().borrow().val;

            if level % 2 == val % 2 {
                return false;
            }

            if last_level == level {
                let is_ok1 = level % 2 == 0 && last_val < val;
                let is_ok2 = level % 2 != 0 && last_val > val;
                if !(is_ok1 || is_ok2) {
                    return false;
                }
            }

            last_level = level;
            last_val = val;

            q.push_back((node.clone().unwrap().borrow().left.clone(), level + 1));
            q.push_back((node.clone().unwrap().borrow().right.clone(), level + 1));
        }
        true
    }
}

fn main() {
    let tree = build_tree(vec![1, 10, 4, 3, -1, 7, 9, 12, 8, 6, -1, -1, 2]);
    println!("{}", Solution::is_even_odd_tree(tree));

    let tree = build_tree(vec![5, 4, 2, 3, 3, 7]);
    println!("{}", Solution::is_even_odd_tree(tree));

    let tree = build_tree(vec![5, 9, 1, 3, 5, 7]);
    println!("{}", Solution::is_even_odd_tree(tree));
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
