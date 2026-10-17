class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(indexMap.containsKey(nums[i])) {
                int idxOne = indexMap.get(nums[i]);
                return new int[]{idxOne, i};
            }
            int diff = target - nums[i];
            indexMap.put(diff, i);
        }
        return new int[2];
    }
}
