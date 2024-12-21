package boj_10866;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static Deque<Integer> dq = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            command(br.readLine());
        }

        System.out.println(sb);
    }

    public static void command(String str) {
        StringTokenizer st = new StringTokenizer(str);
        String cmd = st.nextToken();
        int operand;
        if (cmd.equals("push_front")) {
            operand = Integer.parseInt(st.nextToken());
            dq.addFirst(operand);
        } else if (cmd.equals("push_back")) {
            operand = Integer.parseInt(st.nextToken());
            dq.addLast(operand);
        } else if (cmd.equals("pop_front")) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dq.pollFirst()).append("\n");
            }
        } else if (cmd.equals("pop_back")) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dq.pollLast()).append("\n");
            }
        } else if (cmd.equals("size")) {
            sb.append(dq.size()).append("\n");
        } else if (cmd.equals("empty")) {
            if (!dq.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        } else if (cmd.equals("front")) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dq.getFirst()).append("\n");
            }
        } else {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dq.getLast()).append("\n");
            }
        }
    }
}
