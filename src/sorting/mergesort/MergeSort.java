/**
 * @author:Leo
 * @create 2018/4/11
 * @desc 普通的归并排序
 */
package sorting.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static int[] temp;

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        temp = new int[arr.length];
        sort(arr, 0 , arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int left = low;
        int right = mid + 1;
        //通过比较，一次循环
        for (int i = low; i <= high; i++) {
            // 那部分到达终点，就取另一部分
            if (left > mid) {
                arr[i] = temp[right++];
            } else if (right > high) {
                arr[i] = temp[left++];
            } else if (temp[left] <= temp[right]) {
                arr[i] = temp[left++];
            } else {
                arr[i] = temp[right++];
            }
        }
    }

    /**
     * 生成随机数组
     * @param maxsize
     * @param maxvalue
     * @return
     */
    public static int[] generateRandomArray(int maxsize, int maxvalue){
        int[] arr = new int[(int)(Math.random() * (maxsize + 1))];
        // 生成所有范围在 [0,maxvalue]之间的数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ( Math.random() * (maxvalue + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10, 20);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
