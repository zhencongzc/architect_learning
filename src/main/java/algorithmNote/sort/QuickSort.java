package algorithmNote.sort;

import java.util.Stack;

/**
 * 快速排序
 * 时间复杂度：O(n * log n)
 * 空间复杂度：O(log n)
 * 稳定性：不稳定
 */
public class QuickSort {

    /**
     * 递归实现
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] equalE = partition(arr, L, R);
            process(arr, L, equalE[0]);
            process(arr, equalE[1], R);
        }
    }

    //按末尾值分区，返回小于区域右边界和大于区域左边界
    public static int[] partition(int[] arr, int L, int R) {
        int lessE = L - 1; //小于区域右边界
        int index = L;
        int moreE = R;//大于区域左边界
        while (index < moreE) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessE, index++);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, index, --moreE);
            }
        }
        swap(arr, moreE, R);
        return new int[]{lessE, moreE + 1};
    }

    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }

    /**
     * 非递归实现
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job job = stack.pop();
            int[] equalE = partition(arr, job.left, job.right);
            if (equalE[0] > job.left) {
                Job left = new Job(job.left, equalE[0]);
                stack.add(left);
            }
            if (equalE[1] < job.right) {
                Job right = new Job(equalE[1], job.right);
                stack.add(right);
            }
        }
    }

    public static class Job {
        private int left;
        private int right;

        public Job(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}
