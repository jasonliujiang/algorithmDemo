package offer;

/**
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class o23 {
    //根据二叉搜索树的特性，左子树的节点值根节点小，右子树的节点值都比根节点大
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null||sequence.length == 0){
            return false;
        }
        //递归调用
        return verify(sequence,0,sequence.length-1);
    }

    private boolean verify(int[] sequence, int start, int last) {
        //判断返回正确的情况
        if (last-start<=1){
            return true;
        }

        //获取每次递归的根节点
        int rootVal = sequence[last];
        //左右子树的分割点，代表右子树的第一个节点
        int cutIndex = start;
        while (cutIndex<last&&sequence[cutIndex]<rootVal){
            cutIndex++;
        }
        //遍历右子树，如果有节点小于根节点则返回false
        for (int i = cutIndex;i<last;i++){
            if (sequence[i]<rootVal){
                return false;
            }
        }
        //递归
        return verify(sequence,start,cutIndex-1)&&verify(sequence,cutIndex,last-1);
    }

}
