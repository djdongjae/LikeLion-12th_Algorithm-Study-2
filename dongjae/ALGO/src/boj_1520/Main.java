package boj_1520;

import java.util.*;
import java.io.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] map = new int[501][501];
    public static boolean[][] visited = new boolean[501][501];
    public static int[][] dp = new int[501][501];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(new Node(0, 0)));
    }

    public static int dfs(Node now) {
        visited[now.getX()][now.getY()] = true;

        if (now.getX() == (n - 1) && now.getY() == (m - 1)) {
            return 1;
        }

        if (dp[now.getX()][now.getY()] != -1) {
            return dp[now.getX()][now.getY()];
        }

        dp[now.getX()][now.getY()] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = now.getX() + dx[i];
            int ny = now.getY() + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[now.getX()][now.getY()] > map[nx][ny]) {
                    dp[now.getX()][now.getY()] += dfs(new Node(nx, ny));
                    visited[nx][ny] = false;
                }
            }
        }
        return dp[now.getX()][now.getY()];
    }
}