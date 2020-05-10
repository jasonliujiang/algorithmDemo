package offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class o55_2 {
    /**
     * 参考二叉树深度的算法
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftdep = TreeDepth(root.left);
        int rightdep = TreeDepth(root.right);

        int dif = leftdep-rightdep;
        if (dif>1 || dif<-1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdep = TreeDepth(root.left);
        int rightdep = TreeDepth(root.right);

        return (leftdep > rightdep) ? (leftdep + 1) : (rightdep + 1);

    }

    private boolean isBalanced = true;
    /**
     * 采用后序遍历遍历平衡树，防止节点重复访问
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        getDepth(root);

        return isBalanced;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftdep = getDepth(root.left);
        int rightdep = getDepth(root.right);

        if (Math.abs(leftdep-rightdep)>1){
            isBalanced = false;
        }
        return (leftdep>rightdep)?leftdep+1:rightdep+1;
    }

}



