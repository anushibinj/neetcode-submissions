class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        int curr = 2;
        int runner = 2;
        while(runner < nums.length) {
            // duplicate found. skip it.
            if(nums[curr - 1] == nums[runner] && nums[curr - 2] == nums[runner]) {
                runner++;
            } else { // non-duplicate value. keep it.
                nums[curr] = nums[runner];
                curr++;
                runner++;
            }
        }
        return curr;
    }
}