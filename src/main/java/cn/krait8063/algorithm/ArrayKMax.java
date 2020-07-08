package cn.krait8063.algorithm;

import org.junit.Test;

import java.util.Random;

public class ArrayKMax {


    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    // 在区间 [left, right] 这个区间执行 partition 操作

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        int[] arr = {0, 5, 2, 7, 1, 3};
        int kthLargest = findKthLargest(arr, 2);
        System.currentTimeMillis();

    }

    public int testPartition(int[] arr, int left, int right) {
        int pri = arr[left];
        int j = left;
        for (int i = j + 1; i <= right; i++) {
            if (arr[i] < pri) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, j, left);
        return j;
    }

}
