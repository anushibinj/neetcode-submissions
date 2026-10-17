class Solution {
    public int arraySign(int[] nums) {
        int ctNeg = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                return 0;
            }
            if(nums[i] < 0) {
                ctNeg++;
            }
        }
        return ctNeg %2 == 0 ? 1 : -1;
    }
}