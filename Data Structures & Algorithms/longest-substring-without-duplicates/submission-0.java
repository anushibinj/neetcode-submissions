class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() <= 1) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        char[] sC = s.toCharArray();
        int left = 0;
        int right = 1;
        set.add(sC[left]);
        int maxWin = 0;
        while(right < sC.length) {
            while(set.contains(sC[right])) {
                set.remove(sC[left++]);
            }
            maxWin = Math.max(maxWin, right - left + 1);
            set.add(sC[right]);
            right++;
        }
        return maxWin;
    }
}
