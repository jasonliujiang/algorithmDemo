package datastructure.binarytree;

public class MaxLength {
    private static int MaxLength;

    private void getLength(TreeNode t){
        if (t!=null){
            MaxLength = Math.max(getMaxLength(t),MaxLength);
            getLength(t.right);
            getLength(t.left);
        }
    }



    private int getMaxLength(TreeNode t){
        if (t==null){
            return 0;
        }
        int left = getMaxLength(t.left);
        int right = getMaxLength(t.right);
        return left+right;
    }

    /**
     * 获取当前二叉树的最大高度
     * @param t
     * @return
     */
    private int maxHeigh(TreeNode t){
        if (t==null){
            return 0;
        }else {
            return Math.max(maxHeigh(t.left),maxHeigh(t.right))+1;
        }

    }
}
