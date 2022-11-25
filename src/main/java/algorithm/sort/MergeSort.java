package algorithm.sort;

/**
 * 归并排序
 * 时间复杂度：O(n * log n)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 */
public class MergeSort {

    /**
     * 递归实现
     */
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[L + i1] = help[i1];
        }
    }

    /**
     * 非递归实现
     */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N) {
            int L = 0;
            while (L < N) {
                //step + L > N 时，无需排序
                if (step > N - L) break;
                int M = L + step - 1;
                //右边界超过 N - 1 的时候，右边界为 N - 1
                int R = Math.min(N - 1, (M + 1) + step - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            //防止溢出
            if (step > N / 2) break;
            step <<= 1;
        }
    }

}
