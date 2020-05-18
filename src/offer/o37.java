package offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 */
public class    o37 {

    /**
     * 序列化
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if( root == null) {
            return "";
        }
        StringBuffer treeString = new StringBuffer();
        Serializeing(root, treeString);
        return treeString.toString();
    }

    private void Serializeing(TreeNode root, StringBuffer treeString) {
        if(root == null)
            treeString.append("#,");
        else {
            treeString.append(root.val + ",");
            Serializeing(root.left, treeString);
            Serializeing(root.right, treeString);
        }

    }
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0) {
            return null;
        }
        String[] nodeArray = str.split(",");
        return Deserializeing(nodeArray);
    }


    int index = -1;
    private TreeNode Deserializeing(String[] nodeArray) {
        index++;
        if(!nodeArray[index].equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(nodeArray[index]));
            node.left = Deserializeing(nodeArray);
            node.right = Deserializeing(nodeArray);
            return node;
        }
        return null;
    }
}
