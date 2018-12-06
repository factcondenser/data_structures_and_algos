package mendelProblems;

import java.util.Arrays;

/*
 * Each house in a linearly-arranged neighborhood has a certain store of valuables
 * However, robbing two adjacent houses will raise the alarm
 * What is the maximum haul you can get in a single night?
 *
 * e.g. houses = [25, 20, 1, 1, 2, 30], answer = 56 (from robbing houses i = 0, 2, and 6. 25 + 1 + 30 = 45)
 *                ^^      ^        ^^
 *
 * Do both tabluation and memoization.
 *
 * O(n) time and space
 */
public class HouseRobberSoln {
    public static int robMemo(int[] nums) {
        if (nums.length == 0) return 0;

        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robMemoHelper(nums, 0, memo);
    }

    private static int robMemoHelper(int[] nums, int start, int[] memo) {
        int len = nums.length - start;
        if (len == 1) return nums[start]; // last house
        if (len == 2) return Math.max(nums[start], nums[start + 1]); // last two houses
        if (len == 3) return Math.max(nums[start] + nums[start + 2], nums[start + 1]); // last three houses
        if (memo[start] != -1) return memo[start]; // already computed

        int max = 0;
        int tryOne = nums[start] + robMemoHelper(nums, start + 2, memo);
        int tryTwo = nums[start + 1] + robMemoHelper(nums, start + 3, memo);
        int res = Math.max(tryOne, tryTwo);
        if (res > max) max = res;
        memo[start] = max;
        return max;
    }

    public static int robTab(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);

        int[] tab = new int[nums.length];
        tab[0] = nums[0];
        tab[1] = Math.max(nums[1], nums[0]);
        tab[2] = Math.max(nums[2] + tab[0], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            tab[i] = Math.max(nums[i] + tab[i - 2], nums[i - 1] + tab[i - 3]);
        }
        return tab[nums.length - 1];
    }
}