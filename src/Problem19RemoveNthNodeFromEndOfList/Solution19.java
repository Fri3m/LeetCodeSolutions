package Problem19RemoveNthNodeFromEndOfList;

public class Solution19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution19 solution = new Solution19();
        ListNode result = solution.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println("===========");
        head = new ListNode(1);
        result = solution.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println("===========");
        head = new ListNode(1, new ListNode(2));
        result = solution.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //0ms 41.39MB
        ListNode afterNNode = head;
        for (int i = 1; i < n; i++) {
            afterNNode = afterNNode.next;
        }

        ListNode deleteNode = head;
        ListNode temp = head;

        while (afterNNode.next != null) {
            afterNNode = afterNNode.next;
            temp = deleteNode;
            deleteNode = deleteNode.next;
        }
        if(temp == deleteNode) {
            return head.next;
        }
        temp.next = deleteNode.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
