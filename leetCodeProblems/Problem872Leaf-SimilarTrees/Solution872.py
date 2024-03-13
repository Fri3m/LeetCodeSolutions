class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def createLeafList(root):
    """""
    :type root: TreeNode
    :rtype: List[TreeNode]
    """""
    stackx = [root]
    result = []
    while len(stackx) > 0:
        node = stackx.pop()
        if node.left is None and node.right is None:
            result.append(node)
        else:
            if node.left is not None:
                stackx.append(node.left)
            if node.right is not None:
                stackx.append(node.right)
    return result


class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        leafList1 = createLeafList(root1)
        leafList2 = createLeafList(root2)
        if len(leafList1) != len(leafList2):
            return False
        for i in range(len(leafList1)):
            if leafList1[i].val != leafList2[i].val:
                return False
        return True
