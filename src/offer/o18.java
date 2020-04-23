package offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class o18 {
    public void Mirror(TreeNode root) {
        //由画图得，通过前序遍历递归翻转
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left!=null){
            Mirror(root.left);
        }

        if (root.right != null){
            Mirror(root.right);
        }
    }
}
