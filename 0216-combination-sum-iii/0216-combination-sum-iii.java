import java.util.*;

class Solution {

    void solve(int start, int k, int target,
               List<Integer> output,
               List<List<Integer>> ans) {

        // Found exactly k numbers with required sum
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Invalid case
        if (k == 0 || target <= 0) {
            return;
        }

        // Numbers are only from 1 to 9
        for (int i = start; i <= 9; i++) {

            // Choose
            output.add(i);

            // Move to i + 1 because each number can be used only once
            solve(i + 1, k - 1, target - i, output, ans);

            // Backtrack
            output.remove(output.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(1, k, n, output, ans);

        return ans;
    }
}