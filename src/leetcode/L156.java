package leetcode;

import offer.TreeNode;

import java.util.Stack;

/**
 * 上下翻转二叉树
 */
public class L156 {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if (root == null){
            return null;
        }

        while (root.left !=null){
            stack.push(root);
            root = root.left;
        }

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (stack.isEmpty()){
                node.right = stack.peek();
                node.left = stack.peek().right;
            }else {
                node.left = null;
                node.right = null;
            }
        }
        return root;

    }
}
