package cn.krait8063.sor;

import org.junit.Test;

public class QuickSort {
    private void sort(int[] arr, int left, int right) {
        if (right <= left) return;
        int index = partition(arr, 0, arr.length - 1);
        sort(arr, 0, index - 1);
        sort(arr, index + 1, right);
    }

    @Test
    public void test() {
        int[] ar = {1, 4, 2, 7, 9, 3, -1};
        sort(ar, 0, ar.length - 1);
    }

    private int partition(int[] array, int left, int right) {
        int prio = array[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i < j && array[i] < prio) i++;
            while (i < j && array[j] > prio) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        array[left] = array[j];
        array[j] = prio;
        return j;
    }
}
