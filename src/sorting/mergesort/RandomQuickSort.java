/**
 * @author:Leo
 * @create 2018/6/11
 * @desc
 */
package sorting.mergesort;

import java.util.Arrays;

public class RandomQuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 对一定范围的数据进行排序
     * @param arr
     * @param left
     * @param right
     */
    public static void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 将范围内的任意一个数作为哨兵，放在最后一个位置
        swap(arr, left + (int)(Math.random()*(right - left + 1)), right);
        // 得到相等的范围
        int[] range = partition(arr, left, right);
        // 左半部分还要排序
        process(arr, left, range[0] - 1);
        // 右半部分还要排序
        process(arr, range[1] + 1, right);
    }

    /**
     * 将给定范围的数据划分为三部分，小中大
     * @return
     */
    public static int[] partition(int[] arr, int left, int right) {
        // 左边界和右边界，分别保存小于 key 和大于 key的范围.arr[right]是哨兵
        int leftRange = left - 1;
        int rightRange = right;

        while (left < rightRange) {
            if (arr[left] < arr[right]) {
                // 注意这里交换的原因是两个指针之间还存在相等的数据
                swap(arr, ++leftRange, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, left, --rightRange);
            } else {
                left++;
            }
        }
        // 将最后一个数放在中间
        swap(arr, rightRange, right);
        return new int[]{leftRange+1, rightRange};
    }


    public static void swap(int[] arr, int i, int j) {
        // 这两种方法不可行，当两个下标相等时，会出现问题，相当于两个值始终相等，最后结果是0
        /*arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];

        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];*/


        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {7,3,2,5,4,1,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
