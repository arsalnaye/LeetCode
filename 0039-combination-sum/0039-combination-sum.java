class Solution {

    static void solve(int[] candidates, int target, int index,
                      List<List<Integer>> ans, List<Integer> output) {

        // Base case: target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Base case: target exceeded or no candidates left
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // Include current candidate
        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index, ans, output);

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude current candidate
        solve(candidates, target, index + 1, ans, output);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, 0, ans, output);

        return ans;
    }
}