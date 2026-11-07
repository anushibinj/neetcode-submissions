class Solution {

    public String encode(List<String> strs) {
        StringBuilder buf = new StringBuilder();
        for(String str : strs) {
            buf.append(str.length()).append("#").append(str);
        }
        // System.out.println("encoded: [" + buf.toString() + "]");
        return buf.toString();
    }

    public List<String> decode(String str) {
        char [] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        while(end < chars.length) {
            // 5#Hello5#World
            StringBuilder numBuf = new StringBuilder();
            while(start < chars.length && chars[start] != '#') {
                numBuf.append(chars[start]);
                start++;
            }
            if(start >= chars.length) {
                break;
            }
            // System.out.println("numBuf at start index [" + start + "] is [" + numBuf.toString() + "]");
            // start++; // move past '#'
            int nextWordLength = Integer.parseInt(numBuf.toString());
            end = start + nextWordLength;
            String nextWord = str.substring(start + 1, end + 1);
            res.add(nextWord);
            start = end + 1;
        }
        return res;
    }
}
