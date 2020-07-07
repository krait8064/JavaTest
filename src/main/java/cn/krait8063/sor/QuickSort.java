package cn.krait8063.sor;

import org.junit.Test;

public class QuickSort {

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int low = left + 1;               // 小于分界点元素的最右侧的指针
        int high = right;                // 大于分界点元素的最左侧的指针
        while (low <= high) {
            if (nums[low] > nums[left]) { // 交换元素确保左侧指针指向元素小于分界点元素
                swap(nums, low, high);
                high--;
            } else {
                low++;
            }
        }
        low--;                          // 回到小于分界点元素数组的最右侧
        swap(nums, left, low);          // 将分界点元素移到左侧数组最右侧
        quickSort(nums, left, low - 1);
        quickSort(nums, low + 1, right);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    @Test
    public void t() {
        int[] ar = {1, 4, 2, 7, 9, 3, -1};
        quickSort(ar, 0, ar.length - 1);
    }
}
