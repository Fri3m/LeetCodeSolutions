package Problem2;

public class Solution2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        Solution2 solution = new Solution2();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1ms 44.04 memory
        ListNode result = new ListNode();
        ListNode current = result;
        int extra = 0;
        while (true) {
            int first =0,second=0;
            if (l1 != null) {
                first = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                second = l2.val;
                l2 = l2.next;
            }
            current.val = (first + second + extra) % 10;
            extra = (first + second + extra) / 10;
            if (l1 != null || l2 != null || extra != 0){
                current.next = new ListNode();
                current = current.next;
            }
            else{
                break;
            }
        }

        return result;
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