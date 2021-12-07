from typing import List
import unittest

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        val = 0
        while head is not None:
            val = (val << 1) | head.val
            head = head.next
        return val


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().getDecimalValue(self.make_head([1, 0, 1])), 5)

    def test_example2(self):
        self.assertEqual(Solution().getDecimalValue(self.make_head([0])), 0)

    def test_example3(self):
        self.assertEqual(Solution().getDecimalValue(self.make_head([1])), 1)

    def make_head(self, vals: List[int]) -> ListNode:
        nodes = [ListNode(val=val, next=None) for val in vals]
        for i in range(len(nodes)-1):
            nodes[i].next = nodes[i+1]
        return nodes[0]

if __name__ == '__main__':
    unittest.main()