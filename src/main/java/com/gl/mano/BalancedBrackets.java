package com.gl.mano;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets { public static void main(String[] args) {
        String expr = "([{}])";
        if (areBalancedBracketsConsist(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    static boolean areBalancedBracketsConsist(String expr) {
        Deque<Character> bracketStack = new ArrayDeque<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                bracketStack.push(c);
                continue;
            }
            if (bracketStack.isEmpty())
                return false;
            char check;
            switch (c) {
                case ')':
                    check = bracketStack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = bracketStack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = bracketStack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (bracketStack.isEmpty());
    }
}
