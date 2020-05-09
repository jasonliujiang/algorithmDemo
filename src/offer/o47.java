package offer;

/**
 * 在一个mxn的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0），你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿多少价值的礼物？
 * f(i,j)=max(f(i-1,j),f(i,j-1))+gift(i,j)
 */
public class o47 {
    public int getMaxValue(int[][] values){
        int rows = values.length;
        int cols = values[0].length;

        int[][] maxV = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;

                if (i > 0) {
                    up = maxV[i-1][j];
                }

                if (j>0){
                    left = maxV[i][j-1];
                }

                maxV[i][j] = Math.max(up,left)+values[i][j];
            }

        }
        return values[rows-1][cols-1];
    }
}
