package boj_1707;

import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static int v, e;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            visited = new int[v+1];
            graph = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                graph.add(new ArrayList<>());
            }

            for (int l = 0; l < e; l++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean flag = true;
            for (int x = 1; x <= v; x++) {
                if (visited[x] == 0) {
                    if (!bfs(x)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 1;
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (visited[next] == 0) {
                    if (visited[now] == 1) visited[next] = 2;
                    else visited[next] = 1;
                    q.offer(next);
                } else {
                    if (visited[next] == visited[now]) return false;
                }
            }
        }
        return true;
    }
}
