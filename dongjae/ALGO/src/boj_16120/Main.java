package boj_16120;

import java.util.*;
import java.io.*;

public class Main {
    public static String str;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            stack.push(now);
            if (stack.size() >= 4) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    sb.insert(0, stack.pop());
                }
                if (sb.toString().equals("PPAP")) {
                    stack.push('P');
                } else {
                    for (int j = 0; j < 4; j++) {
                        stack.push(sb.charAt(j));
                    }
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
