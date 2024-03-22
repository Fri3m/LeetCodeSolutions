
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        stack = list()
        if head is None:
            return True
        start = head
        while head.next is not None:
            stack.append(head.val)
            head = head.next
        stack.append(head.val)
        while len(stack) > 0:
            if stack.pop() != start.val:
                return False
            start = start.next
        return True
