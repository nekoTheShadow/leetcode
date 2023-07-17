# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
    v1 = 0
    until l1.nil?
        v1 *= 10
        v1 += l1.val
        l1 = l1.next
    end

    v2 = 0
    until l2.nil?
        v2 *= 10
        v2 += l2.val
        l2 = l2.next
    end

    v = v1+v2
    return ListNode.new(0) if v==0

    last_node = nil
    while v > 0
        node = ListNode.new(v%10)
        node.next = last_node
        last_node = node
        v /= 10
    end
    last_node
end
