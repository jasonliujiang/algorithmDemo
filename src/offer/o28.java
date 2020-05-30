package offer;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class o28 {
    /**
     * 根据前序遍历，，定义一直遍历模式为根右左。对遍历后的两个数组进行比较
     * <p>
     * 注意把空节点也考虑进去
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalTwo(pRoot, pRoot);

    }

    private boolean isSymmetricalTwo(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        if (pRoot1.val == pRoot2.val) {
            return isSymmetricalTwo(pRoot1.left, pRoot2.right) && isSymmetricalTwo(pRoot1.right, pRoot2.left);
        } else {
            return false;
        }


    }
}
