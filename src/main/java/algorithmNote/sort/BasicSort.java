package algorithmNote.sort;

/**
 * 基本排序算法
 */
public class BasicSort {

    /**
     * 冒泡排序
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 插入排序
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
