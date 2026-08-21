class Solution {
    static void solve(int[] nums, int index, List<Integer> output,
                      List<List<Integer>> ans) {

        // Base case
        if (index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        int currVal = nums[index];

        // Include
        output.add(currVal);
        solve(nums, index + 1, output, ans);

        // Backtracking
        output.remove(output.size() - 1);

        // Exclude all duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        solve(nums, index + 1, output, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        Arrays.sort(nums);

        solve(nums, 0, output, ans);

        return ans;
    }
}