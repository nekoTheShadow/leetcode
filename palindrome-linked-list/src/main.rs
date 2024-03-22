impl Solution {
    pub fn is_palindrome(head: Option<Box<ListNode>>) -> bool {
        let mut cur = head;
        let vals = std::iter::from_fn(move || {
            if let Some(node) = cur.as_mut() {
                let val = node.val;
                cur = node.next.take();
                Some(val)
            } else {
                None
            }
        })
        .collect::<Vec<_>>();
        vals.iter().zip(vals.iter().rev()).all(|(v1, v2)| v1 == v2)
    }
}

struct Solution {}

fn main() {
    println!(
        "{:#?}",
        Solution::is_palindrome(to_listnode(vec![1, 2, 2, 1]))
    );
    println!("{:#?}", Solution::is_palindrome(to_listnode(vec![1, 2])));
}

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

fn to_listnode(vals: Vec<i32>) -> Option<Box<ListNode>> {
    vals.into_iter()
        .rev()
        .fold(None, |next, val| Box::new(ListNode { next, val }).into())
}
