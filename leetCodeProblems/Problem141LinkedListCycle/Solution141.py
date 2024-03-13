class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def hasCycle(self, head): # 43ms 18.93MB
        """
        :type head: ListNode
        :rtype: bool
        """
        for i in range(0, 10 ** 4):
            print(i)
            if head is None:
                return False
            head = head.next

        return True


# Test cases
ListNode1 = ListNode(1)
ListNode2 = ListNode(2)
ListNode3 = ListNode(3)
ListNode4 = ListNode(4)

ListNode1.next = ListNode2
ListNode2.next = ListNode3
ListNode3.next = ListNode4
ListNode4.next = ListNode1

print(Solution().hasCycle(ListNode1))  # True
