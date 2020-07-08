package cn.krait8063.algorithm;

import org.junit.Test;

/**
 * created by krait8064 at 2020/07/08
 */
public class CheckMergeSort {
    //快排
    public void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1 || left > right) {
            return;
        }
        int low = left + 1, high = right;
        while (high >= low) {
            if (arr[low] > arr[left]) {
                swap(arr, low, high);
                high--;
            } else {
                low++;
            }
        }
        low--;
        swap(arr, left, low);
        quickSort(arr, left, low - 1);
        quickSort(arr, low + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {5, 2, 8, 9, 7, 1};
        quickSort(arr, 0, arr.length - 1);
        System.currentTimeMillis();
    }

}
