from typing import List, Optional
import unittest

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

        
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self._isValidBST(root, -float('inf'), float('inf'))

    def _isValidBST(self, root: Optional[TreeNode], minval: int, maxval: int) -> bool:
        return root is None or minval < root.val < maxval and self._isValidBST(root.left, minval, root.val) and self._isValidBST(root.right, root.val, maxval)



class TestSolution(unittest.TestCase):
    def test_example1(self):
        root = self.make_root([2,1,3])
        return self.assertEqual(Solution().isValidBST(root), True)

    def test_example2(self):
        root = self.make_root([5,1,4,None,None,3,6])
        return self.assertEqual(Solution().isValidBST(root), False)

    def test_example3(self):
        root = self.make_root([5,4,6,None,None,3,7])
        return self.assertEqual(Solution().isValidBST(root), False)


    def make_root(self, vals: List[int]) -> TreeNode:
        nodes = [None if val is None else TreeNode(val=val) for val in vals]
        n = len(nodes)
        for i in range(n):
            if i*2+1 < n:
                nodes[i].left = nodes[i*2+1]
            if i*2+2 < n:
                nodes[i].right = nodes[i*2+2]
        return nodes[0]

if __name__ == '__main__':
    unittest.main()