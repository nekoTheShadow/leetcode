# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @param {Integer} k
# @return {ListNode[]}
def split_list_to_parts(head, k)
    n = 0
    cur = head
    until cur.nil?
        n += 1
        cur = cur.next
    end

    ret = []
    cur = head
    k.times do |i|
        len = n/k
        len += 1 if i < n%k

        ret << cur
        (0..len-2).each{ cur = cur.next }

        if cur
            tmp = cur.next
            cur.next = nil
            cur = tmp
        end
    end
    ret
end
