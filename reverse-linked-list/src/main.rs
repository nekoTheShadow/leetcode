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

impl Solution {
    pub fn reverse_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut prev = None;
        let mut cur = head;
        while let Some(mut node) = cur {
            cur = node.next;
            node.next = prev;
            prev = Some(node);
        }
        prev
    }
}

struct Solution {}

fn main() {
    println!(
        "{:#?}",
        Solution::reverse_list(to_listnode(vec![1, 2, 3, 4, 5]))
    );
    println!("{:#?}", Solution::reverse_list(to_listnode(vec![1, 2])));
}

fn to_listnode(vals: Vec<i32>) -> Option<Box<ListNode>> {
    vals.into_iter()
        .rev()
        .fold(None, |next, val| Box::new(ListNode { next, val }).into())
}
