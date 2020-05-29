package offer;

/**
 * 打印从1到最大的n位数
 */
public class o17 {
    //字符串模拟数字加法进位
    public static void Print1ToMaxOfDigit(int n) {
        //初始化字符数组
        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            ch[i] = '0';
        }
        //每位上的递增停止
        while (!Increment(ch)) {
            PrintNumber(ch);//打印
        }
    }

    //+1操作，
    public static boolean Increment(char[] ch) {
        boolean overFlow = false;//停止标志
        int TakeOver = 0;//进位标志
        int len = ch.length;
        for (int i = len - 1; i >= 0; i--) { //从个位开始
            int sum = ch[i] - '0' + TakeOver;
            if (i == len - 1) {
                sum++;
            }
            if (sum >= 10) {
                if (i == 0) {
                    overFlow = true;
                    break;
                } else {
                    TakeOver = 1;
                    ch[i] = '0';
                }
            } else {
                ch[i] = '0';
                ch[i] += sum;
                break;
            }
        }
        return overFlow;
    }

    public static void PrintNumber(char[] ch) {
        boolean flag = true;
        for (int i = 0; i < ch.length; i++) {
            if (flag && ch[i] != '0') {
                flag = false;
            }
            if (!flag) {
                System.out.print(ch[i]);
            }
        }
        System.out.print('\t');
    }
    //---------------------------------------------------------------------------
    //全排列递归

    public static void PrintNumber(int n){
        if(n<=0)
            return;
        int[] number = new int[n];
        for(int i=0;i<10;i++){
            number[0]=i;
            Print_1ToMax_Of_Ndigits(number, n, 0);
        }

    }

    public static void Print_1ToMax_Of_Ndigits(int[] number, int length,int index)
    {
        //检查当前是否 溢出，溢出代表排列已满，即最后一位已经赋值，直接将当前数字number打印即可；
        if(index ==length-1){
            PrintNumber(number);
            return;
        }

    }


    //打印字符数组number
    public static void PrintNumber(int[] number){
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBeginning0 && number[i] != 0) {
                isBeginning0 = false;
            }
            //从第一个非零数字打印
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
    }

}
