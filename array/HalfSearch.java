package array;

/**
 * @title: pl1111w
 * @description: 二分查找
 * @author: Kris
 * @date 2024/5/25 12:15
 */
public class HalfSearch {

    public static void main(String[] args) {
        HalfSearch halfSearch = new HalfSearch();
        int[] arr = new int[]{1, 3, 5, 6, 7, 8, 9, 10};
        int val = 5;
        System.out.println(halfSearch.halfSearch(arr, val));
    }

    public int halfSearch(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (val > arr[mid]) {
                left = mid + 1;
            } else if (val < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
