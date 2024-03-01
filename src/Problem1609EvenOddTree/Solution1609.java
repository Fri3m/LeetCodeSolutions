package Problem1609EvenOddTree;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1609 {
    HashMap<Integer,Integer> map = new HashMap<>();
    public boolean isEvenOddTree(TreeNode root) {
        return nlr(root, 0);
    }

    private boolean nlr(TreeNode node, int depth) {
        if (!(depth % 2 == 0 && node.val % 2 == 1) && !(depth % 2 == 1 && node.val % 2 == 0)) {
            System.out.println(1);
            return false;
        }
        if (map.containsKey(depth)) {
            System.out.println(2);
            if (((map.get(depth) >= node.val)&&(depth % 2 == 0)) || ((map.get(depth) <= node.val)&&(depth % 2 == 1))){
                System.out.println(3);
                return false;
            }
            map.replace(depth, node.val);
        }
        else {
            System.out.println(4);
            map.put(depth, node.val);
        }
        if (node.left != null) {
            System.out.println(5);
             if(!nlr(node.left, depth + 1)) return false;
        }
        if (node.right != null) {
            System.out.println(6);
             if(!nlr(node.right, depth + 1)) return false;
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}