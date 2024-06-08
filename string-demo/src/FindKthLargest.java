/**
 * @title: pl1111w
 * @description: 返回第k个最大元素
 * @author: Kris
 * @date 2024/4/18 21:50
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 3;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }

    private static int quickselect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[k];
        int p = partition(arr, left, right);
        if (k <= p) return quickselect(arr, left, p, k);
        else return quickselect(arr, p + 1, right, k);
    }

    private static int partition(int[] arr, int left, int right) {
        int pv = arr[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (arr[j] > pv && i <= j) {
                j--;
            }
            while (arr[i] < pv && i <= j) {
                i++;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, j, left);
        //交换基准点
        return j;

    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}