# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.eular_tour = []
        self.tour(0, root)  
        
        x1 = -1
        x2 = -1
        for i in range(len(self.eular_tour)):
            depth, node = self.eular_tour[i]
            if node.val == p.val and x1 == -1:
                x1 = i
            if node.val == q.val and x2 == -1:
                x2 = i
        
        min_depth = float('inf')
        min_node = None
        for i in range(min(x1, x2), max(x1, x2)+1):
            depth, node = self.eular_tour[i]
            if depth < min_depth:
                min_depth = depth
                min_node = node

        return min_node

    
    def tour(self, depth: int, cur: 'TreeNode'):
        self.eular_tour.append((depth, cur))
        if cur.left is not None:
            self.tour(depth+1, cur.left)
            self.eular_tour.append((depth, cur))
        if cur.right is not None:
            self.tour(depth+1, cur.right)
            self.eular_tour.append((depth, cur))
