package ValidParentheses;

import org.junit.Test;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            }
            else {
                switch (stack.peek()) {
                    case '(':
                        if (s.charAt(i) == ')') {
                            stack.pop();
                        }
                        else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    case '[':
                        if (s.charAt(i) == ']') {
                            stack.pop();
                        }
                        else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    case '{':
                        if (s.charAt(i) == '}') {
                            stack.pop();
                        }
                        else {
                            stack.push(s.charAt(i));
                        }
                        break;
                }
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public boolean isValid1(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }

        return stack.empty();
    }

    @Test
    public void test() {
        String s1 = "((";
        String s2 = "()[]{}";
        String s3 = "([)]";
        String s4 = "(){}}{";
        String s5 = "({[)";

        assert (!isValid(s1));
        assert (isValid(s2));
        assert (!isValid(s3));
        assert (!isValid(s4));
        assert (!isValid(s5));
    }
}
