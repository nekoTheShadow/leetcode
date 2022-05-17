
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if original is None:
            return None

        if original == target:
            return cloned
        
        ans = self.getTargetCopy(original.left, cloned.left, target)
        if ans is not None:
            return ans
        return self.getTargetCopy(original.right, cloned.right, target)