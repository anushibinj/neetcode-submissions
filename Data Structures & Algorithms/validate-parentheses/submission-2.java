class Solution {
    public boolean isValid(String str) {
        if(str.length() < 2) return false;
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    s.push(c);
                    break;
                case ')':
                    if(s.isEmpty()) return false;
                    if(s.peek() == '(') {
                        s.pop();
                    } else return false;
                    break;
                case '}':
                    if(s.isEmpty()) return false;
                    if(s.peek() == '{') {
                        s.pop();
                    } else return false;
                    break;
                case ']':
                    if(s.isEmpty()) return false;
                    if(s.peek() == '[') {
                        s.pop();
                    } else return false;
                    break;
            }
        }
        return s.isEmpty();
    }
}
