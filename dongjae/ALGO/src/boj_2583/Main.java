package boj_2583;

import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    public static int n, m, k;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int count = 1;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) + 1;
            int x1 = Integer.parseInt(st.nextToken()) + 1;
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    result.add(dfs(new Node(i, j)));
                }
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static int dfs(Node now) {
        visited[now.getX()][now.getY()] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = now.getX() + dx[i];
            int ny = now.getY() + dy[i];
            if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    size += dfs(new Node(nx, ny));
                }
            }
        }
        return size;
    }
}
