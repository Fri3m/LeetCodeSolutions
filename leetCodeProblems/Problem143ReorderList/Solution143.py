# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        firstPart = list()
        secondPart = list()
        current = head
        while current:
            secondPart.append(current)
            if len(firstPart) < len(secondPart):
                firstPart.append(secondPart.pop(0))
            current = current.next

        print("First")
        for x in firstPart:
            print(x.val)
        print("Second")
        for x in secondPart:
            print(x.val)

        length = len(secondPart)
        for i in range(len(firstPart)):
            if i < length:
                temp = secondPart.pop()
                temp.next = firstPart[i].next
                print("temp", temp.val, "temp.next", temp.next.val)
                firstPart[i].next = temp

        if length != len(firstPart):
            firstPart[len(firstPart) - 1].next = None
        else:
            firstPart[len(firstPart) - 1].next.next = None
        return head


x = Solution().reorderList(ListNode(1, ListNode(2, ListNode(3, ListNode(4)))))
print("\nResult")
while x:
    print(x.val)
    x = x.next
