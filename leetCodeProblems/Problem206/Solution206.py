class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None

        result = ListNode(head.val)
        while head.next is not None:
            head = head.next
            result = ListNode(head.val, result)

        return result
