import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 所有都是以升序来做的
 */


public class Sort {


    @Test
    public void learnQuickSort() {
        int[] arr = init();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // 选择一个基准点，大于基准点的往右边，小于基准点的往左边
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tem = arr[left];

            while (i < j) {

                while (i < j && tem <= arr[j]) {
                    j--;
                }
                while (i < j && tem >= arr[i]) {
                    i++;
                }
                if (i < j) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            arr[left] = arr[i];
            arr[i] = tem;
            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);
        }
    }

    // 选择排序，选择最小的，记住它的小标，然后交换
    public void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                change(arr, minIndex, i);
            }
        }
    }

    // 最左边是排序好的，只需要将待插入元素从右往左比较，移动元素
    public void insertSort(int[] arr) {
        /**

         for (int i = 1 ; i < arr.length ; i ++) {
         for (int j = i ; j - 1 >= 0 && arr[j] < arr[j - 1]; j --) {
         // 会交换两个地方的数据，可以改进，改为只移动数据往后
         change(arr, j, j-1);
         }
         }

         */

        // 这样就可以少一个交换操作
        for (int i = 1; i < arr.length; i++) {
            int tem = arr[i];
            int j = i;
            for (; j - 1 >= 0 && tem < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tem;
        }
    }

    // 基于插入排序，将数组按照不同的增量进行切分，然后再进行插入排序，再进行切分（切分依据增量的大小）
    // 难点在于怎么理解间隔数，最常用的间隔 N/2 但是被证明这个并不是最好的，

    public void shellSort(int[] arr) {
        int length = arr.length;
        int h;
        int gap = 3;
/**
 while (h < length / 5) {
 h = h * 5 + 1;
 }
 */
        h = Math.max(length / gap, 1);

        //h = length / 2;
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j - h >= 0 && arr[j] < arr[j - h]; j -= h) {
                    change(arr, j, j - h);
                }
            }
            h = h / gap;
        }

    }

    // 归并排序 将两个有序的数组归并成一个更大的有序数组。
    // 递归排序算法：归并排序。要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来。
    // 自顶向下
    public void mergeSort(int[] arr, int[] aux, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);

    }

    /**
     *  0   0   1
     *
     */
    // 自底向上
    public void mergeSortBU(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];
        // 子数组大小
        for (int len = 1; len < n; len *= 2) {
            // 子数组索引大小
            for (int low = 0; low < n - len; low += len + len) {
                // 为什么是 mid = low + len - 1
                // ( low + (low + len + len - 1)  ) / 2    ->    和  low + len - 1 结果一致
                int mid = low + len - 1;
                int high = Math.min(low + len + len - 1, n - 1);
                merge(arr, aux, low, mid, high);
            }
        }
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        // copy to aux[]
        if (high + 1 - low >= 0) System.arraycopy(arr, low, aux, low, high + 1 - low);

        // merge back to a[]
        // low  mid   high
        //  i       j
        // 将 i 和 就中最小的加入到arr数组中，如果 i > mid  就将 左边的全部加入到数组中， 如果 j > high 就将右边的加入到数组中
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > high) arr[k] = aux[i++];
            else if (aux[j] < aux[i]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    //第一个循环（外循环），负责把需要冒泡的那个数字排除在外；
    //第二个循环（内循环），负责两两比较交换。
    public void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0 ; i < length ; i ++) {
            for (int j = 0 ; j < length - i - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    change(arr, j + 1, j);
                }
            }
        }

    }

    @Test
    public void test() {
        int[] arr = init();
        System.out.println(Arrays.toString(arr));
        //chooseSort(arr);
        //insertSort(arr);
        //shellSort(arr);
        //shell(arr, 4);
        //mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        //mergeSortBU(arr);
        //testMerge(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public int[] init() {
        int[] arr;
        int i = 0;

        if (i == 0) {
            arr = new int[]{5, 2, 1, -9, 1, 12, 7, 4, 3, 1, 6, 6, 6, 6, -1, -4};
        }else {
            arr = new int[]{2, 1};
        }
        return arr;
    }

    public void change(int x, int y) {
        int tem = x;
        x = y;
        y = tem;
    }

    public void change(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    // =================================     重新理解    ========================================
    // 重新理解
    public void shell(int[] arr, int gap) {
        int length = arr.length;
        int h = Math.max(length / gap, 1);
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j - h >= 0 && arr[j] < arr[j - h]; j -= h) {
                    change(arr, j, j - h);
                }
            }
            h /= gap;
        }
    }

    public void testMerge(int[] arr){
        int n = arr.length;

        int[] tem = new int[n];

        for(int len = 1; len < n; len += len) {
            for(int low = 0; low < n - len ; low = low + len + len) {
                int mid = low + len - 1;
                int high = Math.max(low + len + len - 1, n - 1);
                merge(arr, tem, low, mid, high);
            }
        }
    }


}
