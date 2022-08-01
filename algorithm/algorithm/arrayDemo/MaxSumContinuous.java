package algorithm.arrayDemo;

/**
 * @title: pl1111w
 * @description: 连续数组最大和
 * @author: Kris
 * @date 2021/3/14 10:04
 */
public class MaxSumContinuous {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, -1, 4, -1, 2, 1, -5, 4};
        MaxSumContinuous maxSumContinuous = new MaxSumContinuous();
        int result = maxSumContinuous.maxSubArray(nums);
        System.out.println(result);
        int result2 = maxSumContinuous.maxSubArray2(nums);
        System.out.println(result2);
    }

    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxValue) {
                maxValue = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxValue;
    }

    public int maxSubArray2(int[] nums) {
        int maxValue = nums[0];
        int[] dap = new int[nums.length];
        dap[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dap[i - 1] < 0) {
                dap[i] = nums[i];
            } else {
                dap[i] = dap[i - 1] + nums[i];
            }
            if (dap[i] > maxValue) {
                maxValue = dap[i];
            }
        }
        return maxValue;
    }
}
