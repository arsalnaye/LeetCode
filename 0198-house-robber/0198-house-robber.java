class Solution {

    static int solve(int[] nums, int index, int[] dp) {

        // base case
        if (index >= nums.length) {
            return 0;
        }

        // already calculated
        if (dp[index] != -1) {
            return dp[index];
        }

        int inc = nums[index] + solve(nums, index + 2, dp);
        int exc = solve(nums, index + 1, dp);

        dp[index] = Math.max(inc, exc);

        return dp[index];
    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
    }
}