class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int j = s.length() - 1;
        for(int i = 0; i < j;) {
            while(!isValidChar(s.charAt(i)) && i < j) {
                System.out.println(s.charAt(i) + " is an invalid char at i");
                i++;
            }
            while(!isValidChar(s.charAt(j)) && i < j) {
                System.out.println(s.charAt(i) + " is an invalid char at j");
                j--;
            }
            if(s.charAt(i) != s.charAt(j)) {
                System.out.println(s.charAt(i) + " != " + s.charAt(j));
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isValidChar(char c) {
        String s = String.valueOf(c);
        return s.matches("[A-Za-z0-9]");
    }
}
