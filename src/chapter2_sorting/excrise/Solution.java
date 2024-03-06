package chapter2_sorting.excrise;

import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] arr, int first, int last) {
        if (last <= first) return;
        int j = partition(arr, first, last);
        quickSort(arr, first, j - 1);
        quickSort(arr, j + 1, last);
    }

    public int partition(int[] arr, int first, int last) {
        int i = first;
        int j = last + 1; // 注意这里是需要
        int v = arr[first];

        while (true) {
            while (arr[++i] < v) {
                if (i == last) break;
            }

            while (v < arr[--j]) {
                if (j == first) break;
            }

            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, first, j); // 把a[v]放在正确的位置上
        return j;
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
