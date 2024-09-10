# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @return {ListNode}
def insert_greatest_common_divisors(head)
    cur = head
    while cur && cur.next
        cur.next = ListNode.new(cur.val.gcd(cur.next.val), cur.next)
        cur = cur.next.next
    end
    head
end
