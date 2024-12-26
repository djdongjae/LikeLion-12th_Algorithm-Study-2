package boj_2206;

import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int y;
    private int broken;

    public Node(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getBroken() {
        return this.broken;
    }
}

public class Main {
    public static int n, m;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[][][] distance;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visited = new boolean[2][n+1][m+1];
        distance = new int[2][n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int result = bfs(new Node(1, 1, 0));

        System.out.println(result == Integer.MAX_VALUE ? "-1" : result);
    }

    public static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        visited[start.getBroken()][start.getX()][start.getY()] = true;
        distance[start.getBroken()][start.getX()][start.getY()] = 1;
        q.offer(start);
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.getX() == n && now.getY() == m) {
                return distance[now.getBroken()][now.getX()][now.getY()];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                int broken = now.getBroken();
                if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
                    if (map[nx][ny] == 0 && !visited[broken][nx][ny]) {
                        visited[broken][nx][ny] = true;
                        distance[broken][nx][ny] = distance[broken][now.getX()][now.getY()] + 1;
                        q.offer(new Node(nx, ny, broken));
                    }

                    if (map[nx][ny] == 1 && broken == 0 && !visited[broken][nx][ny]) {
                        visited[1][nx][ny] = true;
                        distance[1][nx][ny] = distance[broken][now.getX()][now.getY()] + 1;
                        q.offer(new Node(nx, ny, 1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}