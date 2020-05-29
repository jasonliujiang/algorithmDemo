package offer;

/**
 * 二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class o8 {
    /**
     * 根据中序遍历的定义：
     * 1.如果该结点有右子节点，则它的下一个节点是它右节点的最左边节点
     * 2.如果没有右子节点，则一直向上找它的父节点，如果该节点是父子节点的左节点，直接返回
     * 如果不是，继续向上遍历查找，
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            TreeLinkNode rNode = pNode.right;
            while (rNode.left != null) {
                rNode = rNode.left;
            }
            return rNode;
            //右子树为空的情况
        } else if (pNode.next!=null){
            TreeLinkNode parent = pNode.next;
            if (parent.left == pNode) {
                return parent;
            } else {
                while (parent.next != null) {
                    TreeLinkNode parentNext = parent.next;
                    if (parentNext.left == parent) {
                        return parentNext;
                    } else {
                        parent = parentNext;
                    }
                }
                return null;
            }

        }else {
            return null;
        }


    }
}
