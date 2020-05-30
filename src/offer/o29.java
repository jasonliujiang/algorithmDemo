package offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class o29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int col = matrix[0].length;
        int row = matrix.length;
        if (matrix == null || col < 0 || row <= 0) {
            return null;
        }
        int start = 0;
        //判断循环的圈数
        //循环继续的条件是col>startX*2  row>startY*2
        while (col > start * 2 && row > start * 2) {
            ArrayList<Integer> list = PrintMatrixCircle(matrix, col, row, start);
            ++start;
            result.addAll(list);
        }
        return result;
    }

    private ArrayList<Integer> PrintMatrixCircle(int[][] matrix, int col, int row, int start) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int endX = col - 1 - start;
        int endY = row - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = matrix[start][i];
            arrayList.add(number);
        }

        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = matrix[i][endX];
                arrayList.add(number);
            }
        }

        //从右往左打印一行
        if (start < endX && start < endY){
            for (int i = endX-1; i >=start ; --i) {
                int number = matrix[endY][i];
                arrayList.add(number);
            }
        }

        //从下往上打印一列
        if (start < endX && start < endY-1){
            for (int i = endY-1; i >= start; --i) {
                int number = matrix[i][start];
                arrayList.add(number);
            }
        }
            return arrayList;
    }
}
