
from typing import List, Optional
import unittest

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution(object):
    def pairSum(self, head: Optional[ListNode]) -> int:
        h1 = head
        h2 = head
        while h1 and h1.next:
            h1 = h1.next.next
            h2 = h2.next
        h2 = self.reverse(h2)

        ans = -1
        while h2:
            ans = max(ans, head.val + h2.val)
            head = head.next
            h2 = h2.next
        return ans

    def reverse(self, head: ListNode):
        prev = None
        cur = head
        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
        return prev

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().pairSum(self.listnode([5,4,2,1])), 6)
    def test_example2(self):
        self.assertEqual(Solution().pairSum(self.listnode([4,2,2,3])), 7)
    def test_example3(self):
        self.assertEqual(Solution().pairSum(self.listnode([1,100000])), 100001)

    def listnode(self, vals: List[int]):
        heads = [ListNode(val) for val in vals]
        for i in range(len(heads)-1):
            heads[i].next = heads[i+1]
        return heads[0]

if __name__ == '__main__':
    unittest.main()