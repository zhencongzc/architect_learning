package algorithm.other;

public class AlgorithmNote {

    /**
     * arr中，只有一种数，出现奇数次
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * arr中，有两种数，出现奇数次
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        //eor = a ^ b
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //找到eor最右边的1
        int rightOne = eor & (~eor + 1);
        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) eor2 ^= arr[i];
        }
        System.out.println("第一个数为：" + eor2 + "第二个数为：" + (eor ^ eor2));
    }

    /**
     * 通过前置求和数组计算数组某一范围内累加值
     */
    public static class RangeSum {
        private int[] preSum;

        public RangeSum(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }
    }

    /**
     * 生成[0,1]范围内的随机数x，其概率为x平方。
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

}
