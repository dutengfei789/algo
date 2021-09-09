package com.tengfei.algo.demo.stack;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(' || chr == '{' || chr == '[') {
                stack.push(chr);
            }else {
                //此处判空处理
                if (stack.empty()) {
                    return false;
                }
                Character peek = stack.pop();
                if (peek == '(' && chr == ')') {
                    continue;
                }

                if (peek == '{' && chr == '}') {
                    continue;
                }
                if (peek == '[' && chr == ']') {
                    continue;
                }
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        boolean valid = (new Solution()).isValid("[");
        System.out.println("valid = " + valid);
    }

}