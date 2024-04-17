import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 删除有序数组中的重复项 II
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5,
 * 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * @author: Kris
 * @date 2024/4/17 21:17
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    //快慢指针 slow标识不重复的个数 fast标识总个数
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


}
