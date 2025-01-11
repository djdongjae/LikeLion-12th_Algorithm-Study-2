package boj_4485;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public int compareTo(Node other) {
        if (this.cost < other.cost) return -1;
        else if (this.cost == other.cost) return 0;
        else return 1;
    }
}

public class Main {
    public static int n;
    public static int[][] map;
    public static int[][] d;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                count += 1;
                map = new int[n][n];
                d = new int[n][n];
                visited = new boolean[n][n];
                StringTokenizer st;
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                        d[i][j] = Integer.MAX_VALUE;
                    }
                }
                dijkstra(new Node(0, 0, map[0][0]));
                sb.append("Problem ").append(count).append(": ");
                sb.append(d[n-1][n-1]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start.getX()][start.getY()] = start.getCost();
        pq.offer(start);
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.getX()][now.getY()]) {
                for (int i = 0; i < 4; i++) {
                    int nx = now.getX() + dx[i];
                    int ny = now.getY() + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        int cost = now.getCost() + map[nx][ny];
                        if (d[nx][ny] > cost) {
                            d[nx][ny] = cost;
                            pq.offer(new Node(nx, ny, cost));
                        }
                    }
                }
                visited[now.getX()][now.getY()] = true;
            }
        }
    }
}
