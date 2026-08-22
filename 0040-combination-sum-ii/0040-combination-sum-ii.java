class Solution {

    static void solve(int[] candidates, int target, int index,
                      List<List<Integer>> ans, List<Integer> output) {

        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        // Include current element
        output.add(candidates[index]);
        solve(candidates, target - candidates[index],
              index + 1, ans, output);

        // Backtrack
        output.remove(output.size() - 1);

        // Skip duplicate elements
        while (index + 1 < candidates.length &&
               candidates[index] == candidates[index + 1]) {
            index++;
        }

        // Exclude current element
        solve(candidates, target, index + 1, ans, output);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, target, 0, ans, output);

        return ans;
    }
}