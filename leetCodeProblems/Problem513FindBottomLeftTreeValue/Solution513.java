package Problem513FindBottomLeftTreeValue;

public class Solution513 {
    int max =-1;
    int value=0;
    // 0ms beats 100% of users with Java && 43.18MB beats 83.03% of users with Java
    public int findBottomLeftValue(TreeNode root) {
        lrn(root,0);
        return max;
    }
    private void lrn(TreeNode node,int lastDepth){
        if(lastDepth > max){
            max = lastDepth;
            value = node.val;
        }
        if(node.left != null){
            lrn(node.left,lastDepth+1);
        }
        if(node.right != null){
            lrn(node.right,lastDepth+1);
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