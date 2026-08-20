import java.util.*;

class Solution {

    static int[][] dp;

    static int solve(int sum, int target, int[][] mat, int row) {

        if (row >= mat.length) {
            return Math.abs(target - sum);
        }

        if (dp[row][sum] != -1) {
            return dp[row][sum];
        }

        int min = Integer.MAX_VALUE;

        for (int num : mat[row]) {

            int ans = solve(
                sum + num,
                target,
                mat,
                row + 1
            );

            min = Math.min(min, ans);
        }

        return dp[row][sum] = min;
    }

    public int minimizeTheDifference(int[][] mat, int target) {

        int sum = 0;

        // Maximum possible sum
        for (int[] row : mat) {
            for (int num : row) {
                sum += num;
            }
        }

        dp = new int[mat.length][sum + 1];

        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, target, mat, 0);
    }
}