package offer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class o54 {
    /**
     * 采用中序遍历
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k==0){
            return null;
        }

        return KthNodeCore(pRoot,k);
    }

    private TreeNode KthNodeCore(TreeNode pRoot, int k) {
        TreeNode target = null;
        if (pRoot.left !=null){
            target = KthNodeCore(pRoot.left,k);
        }
        if (target == null){
            if (k == 1){
                target = pRoot;
            }else {
                k--;
            }
        }
        if (target == null&&pRoot.right!=null){
            target = KthNodeCore(pRoot.right,k);
        }

        return target;
    }


    int index = 0; //计数器
    TreeNode KthNode2(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

}
