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

            if (bfs()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                q.offer(i);
                visited[i] = 1;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int next : graph.get(now)) {
                        if (visited[next] == 0) {
                            visited[next] = (visited[now] == 1) ? 2 : 1;
                            q.offer(next);
                        } else if (visited[next] == visited[now]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
