impl Solution {
    pub fn get_decimal_value(head: Option<Box<ListNode>>) -> i32 {
        let mut ret = 0;
        let mut cur = head;
        while let Some(node) = cur {
            ret = (ret << 1) | node.val;
            cur = node.next;
        }
        ret
    }
}

fn main() {
    assert_eq!(Solution::get_decimal_value(to_list(&[1, 0, 1])), 5);
    assert_eq!(Solution::get_decimal_value(to_list(&[0])), 0);
}

pub struct Solution;

// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

fn to_list(vals: &[i32]) -> Option<Box<ListNode>> {
    if let Some((head, tail)) = vals.split_first() {
        Some(Box::new(ListNode {
            val: *head,
            next: to_list(tail),
        }))
    } else {
        None
    }
}
