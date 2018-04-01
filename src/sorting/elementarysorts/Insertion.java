/**
 * @author:Leo
 * @create 2018/4/1
 * @desc
 * 插入排序
 */
package sorting.elementarysorts;

import java.util.Arrays;

public class Insertion {
    /**
     * 普通插入排序
     * @param arr
     */
    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    /**
     * 改进的插入排序算法，不需每次进行交换，只需要将元素向后移动一位
     * @param arr
     */
    public static void insertionByMove(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0 && temp < arr[j-1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
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
        insertion(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~`");
        int[] arr2 = generateRandomArray(10, 20);
        System.out.println(Arrays.toString(arr2));
        insertionByMove(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
