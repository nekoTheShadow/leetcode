use std::cell::RefCell;
use std::rc::Rc;
impl Solution {
    pub fn flip_equiv(
        root1: Option<Rc<RefCell<TreeNode>>>,
        root2: Option<Rc<RefCell<TreeNode>>>,
    ) -> bool {
        Self::check(&root1, &root2)
    }

    pub fn check(
        root1: &Option<Rc<RefCell<TreeNode>>>,
        root2: &Option<Rc<RefCell<TreeNode>>>,
    ) -> bool {
        match (root1, root2) {
            (None, None) => true,
            (None, Some(_)) => false,
            (Some(_), None) => false,
            (Some(n1), Some(n2)) => {
                n1.borrow().val == n2.borrow().val
                    && ((Self::check(&n1.borrow().left, &n2.borrow().left)
                        && Self::check(&n1.borrow().right, &n2.borrow().right))
                        || (Self::check(&n1.borrow().left, &n2.borrow().right)
                            && Self::check(&n1.borrow().right, &n2.borrow().left)))
            }
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
    let v1 = vec![1, 2, 3, 4, 5, 6, -1, -1, -1, 7, 8];
    let v2 = vec![1, 3, 2, -1, 6, 4, 5, -1, -1, -1, -1, -1, -1, 8, 7];
    println!("{}", Solution::flip_equiv(to_tree(v1), to_tree(v2)));
    println!("{}", Solution::flip_equiv(to_tree(vec![]), to_tree(vec![])));
    println!(
        "{}",
        Solution::flip_equiv(to_tree(vec![]), to_tree(vec![1]))
    );
}
