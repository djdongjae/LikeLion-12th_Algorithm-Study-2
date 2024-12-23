package boj_22866;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        height = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] leftCnt = new int[n+1];
        int[] leftNear = new int[n+1];
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            leftCnt[i] = stack.size();
            leftNear[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        int[] rightCnt = new int[n+1];
        int[] rightNear = new int[n+1];
        for (int i = n; i >= 1; i--) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            rightCnt[i] = stack.size();
            rightNear[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int total = leftCnt[i] + rightCnt[i];
            if (total == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(total).append(" ");
                int closer;
                if (rightNear[i] == Integer.MAX_VALUE) {
                    closer = leftNear[i];
                } else if (leftNear[i] == Integer.MAX_VALUE) {
                    closer = rightNear[i];
                } else {
                    closer = (i - leftNear[i]) <= (rightNear[i] - i) ? leftNear[i] : rightNear[i];
                }
                sb.append(closer).append("\n");
            }
        }

        System.out.println(sb);
    }
}
