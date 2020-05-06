package offer;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class o26 {
    /**
     * 非递归实现
     * 核心思路是中序遍历的非递归算法
     * 修改当前遍历节点与前一遍历节点的指针指向
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        //用于保存中序遍历的上一个节点
        TreeNode pre = null;

        boolean isFirst = true;

        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            if (isFirst){
                //将中序遍历中的第一个节点记为root
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;
            }else {
                pre.right = p;
                p.left = pre;
                pre = p;

            }
            p = p.right;
        }
        return pRootOfTree;
    }
}
