/**
 * @author:Leo
 * @create 2018/3/24
 * @desc
 * 查找一个数组中有多少组数满足三个数和为 0
 *
 * 利用类似相反数的原理，两个数之和的相反数是否存在
 */
package fundamentals.analysis;

import java.util.Arrays;

public class ThreeSumFast {

    public static int threeSumfast(int[] arr) {
        //犯错：此处必须排序，否则不能进行二分查找
        Arrays.sort(arr);

        int res = 0;
        for (int i = 0;i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++){
                int temp = arr[i] + arr[j];
                res = binarySearch(arr, -temp) > j ? ++res : res;
            }
        }
        return res;
    }

    /**
     * 二分查找，返回下标
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < key) {
                low = mid + 1;
            }else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-5,3,-1,7,6,5,2,1};
        System.out.println(threeSumfast(arr));
    }
}
