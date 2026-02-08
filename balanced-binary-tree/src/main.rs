use std::{cell::RefCell, rc::Rc};

impl Solution {
    pub fn is_balanced(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        dfs(&root) != -1
    }
}

fn dfs(cur: &Option<Rc<RefCell<TreeNode>>>) -> isize {
    if let Some(node) = cur {
        let l = dfs(&node.borrow().left);
        if l == -1 {
            return -1;
        }

        let r = dfs(&node.borrow().right);
        if r == -1 {
            return -1;
        }

        if l.abs_diff(r) < 2 {
            std::cmp::max(l, r) + 1
        } else {
            -1
        }
    } else {
        0
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

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

#[cfg(test)]
mod test {
    use std::{cell::RefCell, rc::Rc};

    use crate::{Solution, TreeNode};

    #[test]
    fn example1() {
        let vals = vec![3, 9, 20, -1, -1, 15, 7];
        assert!(Solution::is_balanced(to_tree(vals)))
    }

    #[test]
    fn example2() {
        let vals = vec![1, 2, 2, 3, 3, -1, -1, 4, 4];
        assert!(!Solution::is_balanced(to_tree(vals)))
    }

    #[test]
    fn example3() {
        assert!(Solution::is_balanced(None))
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
}
