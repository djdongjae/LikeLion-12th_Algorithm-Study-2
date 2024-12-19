package boj_4889;

import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.contains("-")) {
                break;
            }
            count++;

            // 사전 준비
            int change = 0;
            Stack<Character> stack = new Stack<>();

            // 본 게임
            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);
                if (now == '{') {
                    stack.push('{');
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        change++;
                        stack.push('{');
                    }
                }
            }

            if (!stack.isEmpty()) {
                change += stack.size() / 2;
            }

            sb.append(count).append(". ");
            sb.append(change).append("\n");
        }

        System.out.println(sb);
    }
}