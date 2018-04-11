/**
 * @author:Leo
 * @create 2018/4/12
 * @desc
 * 自底向上的归并排序
 *
 * 通过循环实现归并排序
 *
 * 首先两两归并（把每个元素想象成一个大小为 1 的数组）
 * 然后四四归并（将两个大小为 2 的数组归并成一个有 4 个元素的数组）
 * 然后八八归并，一直下去
 *
 * 在每一轮归并中，最后一次归并的第二个子数组可能比第一个子数组要小（但这对merge方法不是问题）
 */
package sorting.mergesort;

import java.util.Arrays;

public class MergeSortBottomToTop {
    private static void mergeSortBottomToTop(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 通过循环实现归并排序
        for (int sz = 1; sz < arr.length; sz += sz) {
            for (int lo = 0; lo < arr.length - sz; lo += 2*sz) {
                merge(arr, lo, lo + sz - 1, Math.min(lo + 2*sz -1, arr.length-1));
            }
        }
    }

    private static void merge(int[] arr, int lo, int mid, int high) {
        int[] temp = new int[arr.length];
        // 拷贝数组元素
        for (int i = lo; i<= high; i++) {
            temp[i] = arr[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k < high + 1; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > high) {
                arr[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
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
        mergeSortBottomToTop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
