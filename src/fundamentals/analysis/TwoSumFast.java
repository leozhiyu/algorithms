/**
 * @author:Leo
 * @create 2018/3/24
 * @desc
 * 查找数组中有多少对和为 0 的数
 * 时间复杂度为 O(N*logN)
 *
 * 利用相反数，遍历的过程中，看其在剩下的数组部分是否有相反数
 */
package fundamentals.analysis;

import java.util.Arrays;

public class TwoSumFast {
    /**
     * 查找个数
     * @param arr
     * @return
     */
    public static int twoSumFast(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                break;
            }
            // 如果存在相反数，那么 res 就增加
            //犯过的错误：将 ++res 写成了 res++，导致 res 始终为 0
            res = binarySearch(arr, -arr[i]) > i ? ++res : res;
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
        int[] arr = {-5,7,-1,-1,-6,8,6,5,-10,2,1};
        System.out.println(twoSumFast(arr));
    }
}
