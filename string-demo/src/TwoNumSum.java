import java.util.Arrays;
import java.util.HashMap;

/**
 * @title: pl1111w
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * @author: Kris
 * @date 2024/4/15 14:49
 */
public class TwoNumSum {

    public static void main(String[] args) {
        TwoNumSum sum = new TwoNumSum();
        int[] nums = new int[]{2,5,5,11};
        int target = 10;
        System.out.println(Arrays.toString(sum.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            //2,5,5,11 避免下标重复
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                if (map.get(nums[i]) > i) {
                    result[0] = i;
                    result[1] = map.get(nums[i]);
                } else {
                    result[1] = i;
                    result[0] = map.get(nums[i]);
                }
            }
        }
        return result;
    }
}
