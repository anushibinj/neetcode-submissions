class Solution {
    public boolean isValid(String str) {
        if(str.length() < 2) return false;
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(' || c =='{' || c == '[') {
                s.push(c);
                continue;
            }
            // not an opening bracket. So, it is a closing bracket.
            // So, the stack must not be empty.
            if(s.isEmpty()) return false;
            if(c == ')' && s.peek() == '('
            || c == '}' && s.peek() == '{'
            || c == ']' && s.peek() == '[') {
                s.pop();
            } else {
                return false;
            }
        }
        return s.isEmpty();
    }
}
