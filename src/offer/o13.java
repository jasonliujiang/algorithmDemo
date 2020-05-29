package offer;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class o13 {
    /**
     * 参考上一题，用回溯法
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {

            return 0;
        }
        //定义标志位，初始化为false(默认为空)
        boolean[] flag = new boolean[rows*cols];

        int count = moveCount(threshold,rows,cols,flag,0,0);

        return count;

    }

    /**
     * 递归调用回溯法
     * @param threshold
     * @param rows
     * @param cols
     * @param flag
     * @param i
     * @param j
     * @return
     */
    private int moveCount(int threshold, int rows, int cols, boolean[] flag, int i, int j) {
        int count = 0;

        if (check(threshold,rows,cols,flag,i,j)){

            flag[i*cols+j] = true;
            count = 1+moveCount(threshold,rows,cols,flag,i+1,j)
                    +moveCount(threshold,rows,cols,flag,i-1,j)
                    +moveCount(threshold,rows,cols,flag,i,j+1)
                    +moveCount(threshold,rows,cols,flag,i,j-1);
        }

        return count;

    }

    /**
     * 判断机器人能否到达这个格子
     * @param threshold
     * @param rows
     * @param cols
     * @param flag
     * @param i
     * @param j
     * @return
     */
    private boolean check(int threshold, int rows, int cols, boolean[] flag, int i, int j) {
        if (i>=0&&j>=0&&i<rows&&j<cols&&!flag[i*cols+j]&&getSum(threshold,i,j)){
            return true;
        }
        return false;

    }

    /**
     * 判断ij数位之和能否大于threshold
     * @param threshold
     * @param i
     * @param j
     * @return
     */
    private boolean getSum(int threshold, int i, int j) {
        if (getDigSum(i)+getDigSum(j)>threshold){
            return false;
        }
        return true;

    }

    private int getDigSum(int i) {
        int sum = 0;
        while (i>0){
            sum += i%10;
            i /=10;
        }
        return sum;
    }
}
