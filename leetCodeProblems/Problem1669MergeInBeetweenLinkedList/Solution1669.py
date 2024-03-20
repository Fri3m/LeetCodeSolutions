class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def mergeInBetween(self, list1, a, b, list2):
        """
        :type list1: ListNode
        :type a: int
        :type b: int
        :type list2: ListNode
        :rtype: ListNode
        """
        head = list1
        for _ in range(a - 1):
            list1 = list1.next
        left = list1
        for _ in range(b - a + 2):
            list1 = list1.next
        right = list1
        left.next = list2
        while left.next is not None:
            left = left.next
        left.next = right
        return head
