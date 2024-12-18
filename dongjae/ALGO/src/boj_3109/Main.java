package boj_3109;

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
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static int r, c;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {1, 1, 1};
    public static int count = 0;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = charArr[j];
            }
        }

        for (int i = 0; i < r; i++) {
            flag = false;
            dfs(new Node(i, 0));
        }

        System.out.println(count);
    }

    public static void dfs(Node start) {
        visited[start.getX()][start.getY()] = true;
        if (start.getY() == c - 1) {
            count++;
            flag = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = dx[i] + start.getX();
            int ny = dy[i] + start.getY();
            if (nx >= 0 && ny >=0 && nx < r && ny < c) {
                if (!visited[nx][ny] && map[nx][ny] != 'x') {
                    if (flag) {
                        return;
                    }
                    dfs(new Node(nx, ny));
                }
            }
        }
    }
}