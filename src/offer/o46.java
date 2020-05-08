package offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。
 * 例如12258有5种不同的翻译，它们分别"bccfi", "bwfi", "bczi", "mcfi" 和"mzi" 。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class o46 {
    public int getTranslationCount(int number) {
        if (number < 0) {
            return -1;
        }

        String sNumber = String.valueOf(number);
        int len = sNumber.length();
        int[] count = new int[len];

        //从左向右顺序递归可能出现重复情况，所以从数字的末尾开始计算
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                count[i] = 1;
            } else {
                count[i] = count[i+1];

                if (canBeTrans(sNumber, i)) {
                    if (i == len - 2) {
                        count[i] += 1;
                    } else {
                        count[i] += count[i+2];
                    }
                }

            }
        }

        return count[0];

    }

    /**
     * 用递归思想无法解决的时候，可以采用自底向上的方法，采用动态规划的方式解决
     * 判断第i位和第i+1位的组合是否有重复情况
     *
     * @param sNumber
     * @param i
     * @return
     */
    private boolean canBeTrans(String sNumber, int i) {
        int a = sNumber.charAt(i) - '0';
        int b = sNumber.charAt(i + 1) - '0';
        int convert = a * 10 + b;
        if (convert > 10 && convert < 26) {
            return true;
        }

        return false;
    }
}
