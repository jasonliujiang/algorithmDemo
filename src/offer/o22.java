package offer;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class o22 {

    /**
     * 通过队列的数据结构完成二叉树的层序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode tnVal = queue.poll();
            //可能存在当前节点为空的情况，跳出循环继续遍历下一个节点
            if (tnVal == null){
                continue;
            }
            result.add(tnVal.val);
            if (tnVal.left!=null | tnVal.right !=null){
                queue.add(tnVal.left);
                queue.add(tnVal.right);
            }
        }

        return result;
    }


}
