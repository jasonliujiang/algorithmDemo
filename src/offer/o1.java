package offer;
/*
* 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
* 每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
* */
public class o1 {
    //从左下找，上面的一定小，右边的一定大
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int i = rows - 1;
        if (rows == 0){
            return false;
        }
        int cols = array[0].length;
        int j = 0;
        if (cols == 0){
            return false;
        }
        while (i >= 0 && j < cols) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}