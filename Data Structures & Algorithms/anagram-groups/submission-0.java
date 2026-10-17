class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            int[] charCount = new int[26];
            for(int i = 0; i < s.length(); i++) {
                charCount[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(charCount);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return map.values().stream().toList();
    }
}
