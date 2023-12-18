package Blind75.Strings;

import java.util.Stack;

public class LC_20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char i: s.toCharArray()){
            if(i =='(' || i=='{' || i=='['){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.peek();
                if((i==')' && top=='(' )|| (i=='}' && top=='{' ) ||  (i==']' && top=='[' )){
                    stack.pop();
                }else{
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC_20_Valid_Parentheses obj = new LC_20_Valid_Parentheses();
        String s = "()[]{}";
        System.out.println(obj.isValid(s));
    }
}
