class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


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


def makeTree(vals, p, q):
    nodes = [None if val is None else TreeNode(val) for val in vals]
    n = len(nodes)
    for i in range(n):
        if 2*i+1 < n:
            nodes[i].left = nodes[2*i+1]
        if 2*i+2 < n:
            nodes[i].right = nodes[2*i+2]
    return nodes[0], nodes[vals.index(p)], nodes[vals.index(q)]

if __name__ == '__main__':
    root, p, q = makeTree([3,5,1,6,2,0,8,None,None,7,4], 5, 4)
    print(Solution().lowestCommonAncestor(root, p, q).val)