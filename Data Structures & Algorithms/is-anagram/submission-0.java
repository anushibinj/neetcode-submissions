class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for(char aSChar : s.toCharArray()) {
            int oldCount = counter.getOrDefault(aSChar, 0);
            counter.put(aSChar, oldCount + 1);
        }
        for(char aSChar : t.toCharArray()) {
            int oldCount = counter.getOrDefault(aSChar, 0);
            counter.put(aSChar, oldCount - 1);
        }
        long nonZeroCount = counter.values().stream().filter(v -> v != 0).count();
        // if anagram, there will be at least one non-zero count
        System.out.println(nonZeroCount);
        return nonZeroCount == 0;
    }
}
