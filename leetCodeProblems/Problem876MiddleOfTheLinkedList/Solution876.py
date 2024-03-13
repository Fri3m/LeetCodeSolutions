class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def middleNode(self, head): # 11ms 11.72MB
        """
        :type head: ListNode
        :rtype: ListNode
        """
        mid, end = head, head
        while end.next is not None:
            mid = mid.next
            end = end.next
            if end.next is not None:
                end = end.next
        return mid


print(Solution().middleNode(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))).val)
