# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        self.dfs(target, None, None, root)
        if root.left is None and root.right is None and root.val == target:
            return None
        else:
            return root
        
    def dfs(self, target: int, pre: Optional[TreeNode], which: str, cur: Optional[TreeNode]):
        if cur.left is None and cur.right is None and cur.val == target:
            if which == "L":
                pre.left = None
            if which == "R":
                pre.right = None
            return 
        
        if cur.left is not None:
            self.dfs(target, cur, "L", cur.left)
        if cur.right is not None:
            self.dfs(target, cur, "R", cur.right)

        if cur.left is None and cur.right is None and cur.val == target:
            if which == "L":
                pre.left = None
            if which == "R":
                pre.right = None
            return 

        


def buid_tree(vals: List[int]) -> TreeNode:
    nodes = [None if val is None else TreeNode(val=val) for val in vals]
    n = len(nodes)
    for i in range(n):
        if nodes[i] is None:
            continue
        if 2*i+1 < n:
            nodes[i].left = nodes[2*i+1]
        if 2*i+2 < n:    
            nodes[i].right = nodes[2*i+2]
    return nodes[0]

def print_tree(root: TreeNode):
    stack = [(root, 0)]
    vals = []
    while stack:
        node, x = stack.pop()
        if node is None:
            continue

        while len(vals) <= x:
            vals.append(None)
        vals[x] = node.val

        stack.append((node.left, 2*x+1))
        stack.append((node.right, 2*x+2))
    print(vals)


print_tree(Solution().removeLeafNodes(buid_tree([1,2,3,2,None,2,4]), 2))
print_tree(Solution().removeLeafNodes(buid_tree([1,3,3,3,2],), 3))
print_tree(Solution().removeLeafNodes(buid_tree([1,2,None,2,None,2],), 2))
print_tree(Solution().removeLeafNodes(buid_tree([1,1,1]), 1))
# print_tree(Solution().removeLeafNodes(buid_tree([0, 1, 2, 3, 4, 5]), 2))