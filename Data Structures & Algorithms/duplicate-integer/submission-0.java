class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for(int num : nums) {
            if(!uniq.add(num)) {
                return true;
            }
        }
        return false;
    }
}