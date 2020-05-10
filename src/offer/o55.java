package offer;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class o55 {
    /**
     * 采用递归的思想，如果既有左子树又有右子树，则为其最大值+1；
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftdep = TreeDepth(root.left);
        int rightdep = TreeDepth(root.right);

        return (leftdep>rightdep)?(leftdep+1):(rightdep+1);

    }
}
