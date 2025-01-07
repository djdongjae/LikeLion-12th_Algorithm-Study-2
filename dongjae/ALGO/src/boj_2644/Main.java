package boj_2644;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int t1, t2;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int answer = dfs(t1, t2, 0);
        System.out.println(answer);
    }

    public static int dfs(int start, int end, int depth) {
        visited[start] = true;
        if (start == end) {
            return depth;
        }
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                int result = dfs(next, end, depth + 1);
                if (result != -1) {
                    return result;
                }
            }
        }
        return -1;
    }
}