package practice;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 */
public class deleteNode {
    private boolean mark;
    private TreeNode one, two;

    /**
     * dfs遍历一遍找到key，然后存储key结点的左子树将其加到key右子树的最左边就ok了。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        mark = false;
        one = two = null;

        if (root.val == key && root.right == null) {
            return root.left;
        }

        dfs(root, null, -1, key);

        if (root.val == key) {
            return root.right;
        }

        return root;
    }

    private void dfs(TreeNode root, TreeNode p, int id, int key) {
        if (root == null || mark) {
            return;
        }
        if (root.val < key) {
            dfs(root.right, root, 1, key);
        } else if (root.val > key) {
            dfs(root.left, root, 0, key);
        } else {
            if (root.right == null) {
                if (id == 0) {
                    p.left = root.left;
                } else if (id == 1) {
                    p.right = root.left;
                }
            } else {
                mark = true;
                TreeNode tmp = root.left;
                root.left = null;
                if (id == 0) {
                    p.left = root.right;
                } else if (id == 1) {
                    p.right = root.right;
                }
                root = root.right;
                while (root.left != null) {
                    root = root.left;
                }
                root.left = tmp;
            }
        }
    }


}
