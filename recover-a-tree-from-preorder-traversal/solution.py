import re

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def recoverFromPreorder(self, S: str) -> TreeNode:
        tokens = re.findall('-+|\d+', S)
        depths = [0]
        nodes = [TreeNode(int(tokens[0]))]
        for i in range(1, len(tokens), 2):
            depths.append(len(tokens[i]))
            nodes.append(TreeNode(int(tokens[i+1])))
        
        for i in range(1, len(nodes)):
            for j in reversed(range(i)):
                if depths[i] == depths[j] + 1:
                    if nodes[j].left is None:
                        nodes[j].left = nodes[i]
                    else:
                        nodes[j].right = nodes[i]
                    break

        return nodes[0]
    




