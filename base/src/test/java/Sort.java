import org.junit.Test;

import java.util.Arrays;

/**
 *  所有都是以升序来做的
 */


public class Sort {


    @Test
    public void learnQuickSort() {
        int[] arr = init();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tem = arr[left];

            while (i < j) {

                while (i < j && tem <= arr[j]) {
                    j --;
                }
                while (i < j && tem >= arr[i]) {
                    i ++;
                }
                if (i<j) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            arr[left] = arr[i];
            arr[i] = tem;
            quickSort(arr, left, j-1);
            quickSort(arr,j + 1, right);
        }
    }

    public void chooseSort(int[] arr) {
        for (int i = 0 ; i < arr.length ; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length ; j ++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i){
                change(arr, minIndex, i);
            }
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 1 ; i < arr.length ; i ++) {
            for (int j = i ; j - 1 >= 0 && arr[j] < arr[j - 1]; j --) {
                change(arr, j, j-1);
            }
        }
    }

    public void change(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    @Test
    public void test() {
        int[] arr = init();
        System.out.println(Arrays.toString(arr));
        //chooseSort(arr);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public int[] init() {
        int[] arr = new int[]{5,2,1,-9,1,12,7,4,3,1,6,6,6,6,-1,-4};
        return arr;
    }

}
