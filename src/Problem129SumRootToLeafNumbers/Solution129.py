# 4ms 11.62MB
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    allNumbers = []

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.returnNumbers(root, 0)
        print(self.allNumbers)

        result = sum(self.allNumbers)
        self.allNumbers[:] = []
        return result


    def returnNumbers(self, node, x):
        if node.left is None and node.right is None:
            self.allNumbers.append(x * 10 + node.val)
        else:
            if node.left is not None:
                self.returnNumbers(node.left, x * 10 + node.val)
            if node.right is not None:
                self.returnNumbers(node.right, x * 10 + node.val)


# Path: src/Problem129SumRootToLeafNumbers/Solution129.py
print(Solution().sumNumbers(TreeNode(1, TreeNode(2), TreeNode(3))))
print(Solution().sumNumbers(TreeNode(4, TreeNode(9, TreeNode(5), TreeNode(1)), TreeNode(0))))
