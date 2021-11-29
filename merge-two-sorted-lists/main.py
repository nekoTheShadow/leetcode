from typing import Optional, List
import unittest

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = None
        cur = None
        while list1 is not None or list2 is not None:
            if list2 is None or (list1 is not None and list1.val < list2.val):
                if cur is None:
                    head = list1
                else:
                    cur.next = list1
                cur = list1
                list1 = list1.next
            else:
                if cur is None:
                    head = list2
                else:
                    cur.next = list2
                cur = list2
                list2 = list2.next
        return head

    # def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    #     if list1 is None:
    #         return list2
    #     if list2 is None:
    #         return list1

    #     if list1.val < list2.val:
    #         list1.next = self.mergeTwoLists(list1.next, list2)
    #         return list1
    #     else:
    #         list2.next = self.mergeTwoLists(list1, list2.next)
    #         return list2

                

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.helper([1,2,4], [1,3,4], [1,1,2,3,4,4])
    
    def test_example2(self):
        self.helper([], [], [])
    
    def test_example3(self):
        self.helper([], [0], [0])

    def helper(self, vals1: List[int], vals2: List[int], expected: List[int]):
        list1 = self.createListNode(vals1)
        list2 = self.createListNode(vals2)

        head = Solution().mergeTwoLists(list1, list2)
        vals = []
        while head is not None:
            vals.append(head.val)
            head = head.next
        self.assertEqual(vals, expected)

    def createListNode(self, vals: List[int]) -> ListNode:
        if len(vals) == 0:
            return None

        listNodes = [ListNode(val=val) for val in vals]
        for i in range(len(listNodes)-1):
            listNodes[i].next = listNodes[i+1]
        return listNodes[0]


if __name__ == '__main__':
    unittest.main()