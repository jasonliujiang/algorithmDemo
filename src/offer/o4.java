package offer;

import java.util.Arrays;

/*
*递归构建二叉树
* 已知前序和中序，构建后序
* */
public class o4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        //在中序中找到根
        for (int i =0;i<in.length;i++){
            if (in[i] == pre[0]){
                //左子树，注意copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,1));
                //右子树，注意copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;

            }
        }
        return root;
    }
}
