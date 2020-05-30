package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 */
public class o32_2 {
    /**
     * 设置两个标志位，记录当前层和下一层的节点数
     * @param root
     */
    public void PrintFromTopToBottom(TreeNode root) {
        if (root == null) {

            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int nowLevel = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()){
            TreeNode tNode = queue.poll();
            System.out.print(tNode.val);

            if (tNode.left != null) {
                queue.add(tNode.left);
                nextLevel++;
            }

            if (tNode.right != null) {
                queue.add(tNode.right);
                nextLevel++;
            }
            nowLevel--;

            if (nowLevel == 0) {
                System.out.println();
                nowLevel = nextLevel;
                nextLevel = 0;
            }

        }

    }
}
