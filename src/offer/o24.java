package offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class o24 {
    //最终的返回结果
    private  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    //每次遍历的路径
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return result;
        }


        int currentSum = 0;

        FindPathBy(root,currentSum,path,target);

        return result;

    }

    private void FindPathBy(TreeNode root, int currentSum, ArrayList<Integer> path, int target) {
        currentSum += root.val;
        path.add(root.val);

        //判断是否为叶子结点
        boolean isLeaf = root.left == null && root.right == null;
        //如果和相等且为叶子结点则打印路径
        if (currentSum == target && isLeaf){
            result.add(new ArrayList<Integer>(path));
        }

        //如果不是叶子结点，继续向下遍历
        if (root.left!=null){
            FindPathBy(root.left,currentSum,path,target);
        }
        if (root.right!=null){
            FindPathBy(root.right,currentSum,path,target);
        }

        path.remove(path.size()-1);

    }

    //精简算法
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        if (root == null){
            return result;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            //新建一个list对象，否则会引用同一个对象
            result.add(new ArrayList<Integer>(path));
        }
        FindPath2(root.left,target);
        FindPath2(root.right,target);

        path.remove(path.size()-1);
        return result;
    }
}

