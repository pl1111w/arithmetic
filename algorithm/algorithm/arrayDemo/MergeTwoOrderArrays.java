package algorithm.arrayDemo;

/**
 * @title: pl1111w
 * @description:给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * @author: Kris
 * @date 2024/4/9 21:15
 */
public class MergeTwoOrderArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n - 1;
        int j = m - 1;
        int index = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (i < 0) {
                nums1[index--] = nums2[j--];
            } else if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }

    }
}
