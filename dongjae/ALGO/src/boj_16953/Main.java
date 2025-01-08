package boj_16953;

import java.util.*;
import java.io.*;

public class Main {
    public static String a, b;
    public static boolean[] visited;
    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();

        visited = new boolean[1000000001];

        dfs(a, 0);
        if (answer != -1) System.out.println(answer + 1);
        else System.out.println(answer);
    }

    public static void dfs(String now, int depth) {
        if (now.equals(b)) {
            answer = depth;
            return;
        }
        visited[Integer.parseInt(now)] = true;
        String next = null;

        // 곱하기 2
        next = String.valueOf(Integer.parseInt(now) * 2);
        if (Long.parseLong(next) <= 1000000000 && !visited[Integer.parseInt(next)]) {
            dfs(next, depth + 1);
        }

        // 우측 끝에 1 더하기
        StringBuilder sb = new StringBuilder();
        next = sb.append(now).append(1).toString();
        if (Long.parseLong(next) <= 1000000000 && !visited[Integer.parseInt(next)]) {
            dfs(next, depth + 1);
        }
    }
}