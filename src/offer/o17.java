package offer;

/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */
public class o17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //先递归判断两棵树的根节点是否相同

        TreeNode A = root1;
        TreeNode B = root2;
        boolean result = false;
        if (A != null && B != null) {
            //如果根节点相同，判断子节点是否相同
            if (A.val == B.val){
                result = DoesTree1HaveTree2(A,B);
            }
            //以result遍历，防止出现树节点重复的情况
            if (!result){
                result = HasSubtree(A.left,B);
            }
            if (!result){
                result = HasSubtree(A.right,B);
            }
        }


        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode tree1, TreeNode tree2) {
        TreeNode A = tree1;
        TreeNode B = tree2;

        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val != B.val){
            return false;
        }
        return DoesTree1HaveTree2(A.left,B.left) && DoesTree1HaveTree2(A.right,B.right);
    }
}
