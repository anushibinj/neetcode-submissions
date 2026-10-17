class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> subset) {
        if (index >= nums.length) {
            res.add(List.copyOf(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index + 1, nums, subset);
        subset.removeLast();
        dfs(index + 1, nums, subset);
    }
}
