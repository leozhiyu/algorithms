/**
 * @author:Leo
 * @create 2018/4/2
 * @desc 希尔排序
 */
package sorting.elementarysorts;

import java.util.Arrays;

public class Shell {
    /**
     * 希尔排序
     * @param arr
     */
    public static void shell(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int N = arr.length;
        int gap = 1;
        while (gap < N) {
            gap = gap * 3 + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < N; i++) {
                int j = i;
                int temp = arr[i];
                for (; j >= gap && arr[j] < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j-gap];
                    /*int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;*/
                }
                arr[j] = temp;
            }
            gap /= 3;
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
        shell(arr);
        System.out.println(Arrays.toString(arr));
    }
}
