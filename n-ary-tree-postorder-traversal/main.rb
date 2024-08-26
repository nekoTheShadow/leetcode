def postorder(root) = root ? [*root.children.flat_map{postorder(_1)}, root.val] : []
