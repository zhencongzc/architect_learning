package algorithm.sort;

/**
 * 堆排序
 * 时间复杂度：O(n * log n)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        //O(n * log n)
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //如果数组已知可以实现O(n)插入
//		for (int i = arr.length - 1; i >= 0; i--) {
//			heapify(arr, i, arr.length);
//		}
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        //O(n * log n)
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //arr[index]刚来的数，往上
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //arr[index]位置的数，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; //左孩子的下标
        while (left < heapSize) { //下方还有孩子的时候
            //两个孩子中，谁的值大，把下标给largest
            //1）只有左孩子，left -> largest
            //2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
            //3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父和较大的孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}