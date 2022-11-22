package algorithmNote.sort;

/**
 * 基数排序
 * 时间复杂度：O(n * k)
 * 空间复杂度：O(n + k)
 * 稳定性：稳定
 */
public class RadixSort {

    //仅用于非负数
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    //arr[L..R]排序  ,  最大值的十进制位数digit
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        //有多少个数准备多少个辅助空间
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            //10个空间
            //count[0] 当前位(d位)是0的数字有多少个
            //count[1] 当前位(d位)是(0和1)的数字有多少个
            //count[2] 当前位(d位)是(0、1和2)的数字有多少个
            //count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix]; // count[0..9]
            for (i = L; i <= R; i++) {
                //103  1   3
                //209  1   9
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //转换为前缀和数组
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //倒序取数，保证顺序
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    //求最大位数
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    //取第d位的数值
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

}