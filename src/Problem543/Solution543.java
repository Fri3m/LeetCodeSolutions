package Problem543;

public class Solution543 {
    int max = 0;
    public static void main(String[] args) {

    }


    public int diameterOfBinaryTree(TreeNode root) {
        arrangeMaxLengthOfNode(root);
        findMax(root);
        return max;
    }
    private int arrangeMaxLengthOfNode(TreeNode root){
        if (root.right == null && root.left == null){
            return  (root.val = 0);
        }
        else if(root.left == null){
             return (root.val = arrangeMaxLengthOfNode(root.right) + 1);

        }
        else if(root.right == null){
            return (root.val = arrangeMaxLengthOfNode(root.left) + 1);
        }
        else {
            return (root.val = Math.max(arrangeMaxLengthOfNode(root.left), arrangeMaxLengthOfNode(root.right)) + 1);
        }
    }
    private void findMax(TreeNode root){
        System.out.println(root.val);
        if(root.left != null && root.right != null){
            root.val = root.right.val + root.left.val +2;
            findMax(root.left);
            findMax(root.right);
        }
        else if(root.left != null){
            root.val = root.left.val + 1;
            findMax(root.left);
        }
        else if(root.right != null){
            root.val = root.right.val + 1;
            findMax(root.right);
        }
        if(root.val > max){
            max = root.val;
        }
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