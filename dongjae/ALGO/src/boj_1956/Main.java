package boj_1956;

import java.io.*;
import java.util.*;

public class Main {
    public static int v, e;
    public static int[][] graph;
    public static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new int[v+1][v+1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                graph[i][j] = INF;
            }
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        floyd();

        int result = getMinCycle() == INF ? -1 : getMinCycle();
        System.out.println(result);
    }

    public static int getMinCycle() {
        int min = INF;
        for (int i = 1; i <= v; i++) {
            min = Math.min(min, graph[i][i]);
        }
        return min;
    }

    public static void floyd() {
        for (int k = 1; k <= v; k++) {
            for (int a = 1; a <= v; a++) {
                for (int b = 1; b <= v; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }
}
