package offer;

import java.util.*;

/**
 * 之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class o32_3 {
    /**
     * 模拟流程，我们可以推断出
     * 可以用栈来实现节点的存储，并需要两个栈
     * 且奇偶层保存节点的顺序不一样
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //对应奇偶层的栈
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s0 = new Stack<>();

        //游标，带表层数
        int xdr = 0;
        s0.push(pRoot);


        while (!s0.isEmpty() || !s1.isEmpty()) {

            TreeNode tNode = xdr % 2 == 0?s0.pop():s1.pop();
            if (result.size() == xdr){
                result.add(xdr,new ArrayList<Integer>());
                result.get(xdr).add(tNode.val);
            }else {
                result.get(xdr).add(tNode.val);
            }


            if (xdr % 2 == 0) {
                if (tNode.left != null) {
                    s1.push(tNode.left);
                }

                if (tNode.right != null) {
                    s1.push(tNode.right);
                }
            } else {
                if (tNode.right != null) {
                    s0.push(tNode.right);
                }
                if (tNode.left != null) {
                    s0.push(tNode.left);
                }
            }

            if (s0.isEmpty() && s1.isEmpty()){
                return result;
            }

            if (s0.isEmpty() || s1.isEmpty()){
                xdr++;
            }


        }
        return result;


    }




    public class Solution {
        public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> layers = new ArrayList<ArrayList<Integer>>();
            if (pRoot == null)
                return layers;
            Deque<TreeNode> queue = new LinkedList<TreeNode>();

            queue.offer(pRoot);
            int depth = 0;
            while (!queue.isEmpty()) {
                depth ++;
                ArrayList<Integer> layer = new ArrayList<Integer>();
                int cur = 0, size = queue.size();
                if ((depth & 1) == 0) { //如果是偶数层倒序添加
                    Iterator<TreeNode> it = queue.descendingIterator();
                    while (it.hasNext()) {
                        layer.add(it.next().val);
                    }
                }
                else { //如果是奇数层正序添加
                    Iterator<TreeNode> it = queue.iterator();
                    while (it.hasNext()) {
                        layer.add(it.next().val);
                    }
                }
                while (cur < size) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    cur ++;
                }
                layers.add(layer);
            }
            return layers;
        }
    }

}
