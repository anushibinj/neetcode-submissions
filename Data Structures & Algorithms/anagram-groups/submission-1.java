class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqMap = new HashMap<>();
        for(String str : strs) {
            String freqMapString = stringToFreqMapString(str);
            List<String> group = freqMap.get(freqMapString);
            if(group == null) {
                group = new ArrayList<>();
                freqMap.put(freqMapString, group);
            }
            group.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> value : freqMap.values()) {
            res.add(value);
        }
        return res;
    }

    private String stringToFreqMapString(String str) {
        int[] freqArr = new int[26];
        char[] chars = str.toCharArray();
        for(char c : chars) {
            freqArr[c - 'a']++;
        }
        StringBuilder freqMap = new StringBuilder(26);
        for(int freq : freqArr) {
            freqMap.append(freq).append(";");
        }
        return freqMap.toString();
    }
}
