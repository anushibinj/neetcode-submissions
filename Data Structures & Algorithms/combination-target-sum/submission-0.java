class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int i, int currSum, List<Integer> curr) {
        if(currSum == target) {
            res.add(List.copyOf(curr));
            return;
        }
        if(currSum > target || i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        currSum += nums[i];
        dfs(nums, target, i, currSum, curr);
        curr.removeLast();
        currSum -= nums[i];
        dfs(nums, target, i + 1, currSum, curr);
    }
}
