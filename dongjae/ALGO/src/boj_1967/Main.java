package boj_1967;

import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int distance;

    public Node(int x, int distance) {
        this.x = x;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class Main {
    public static int n;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static boolean[][] visited;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, new Node(i, 0), 0);
        }

        System.out.println(max);
    }

    public static void dfs(int start, Node now, int prev) {
        visited[start][now.getX()] = true;
        for (int i = 0; i < graph.get(now.getX()).size(); i++) {
            Node next = graph.get(now.getX()).get(i);
            if (!visited[start][next.getX()]) {
                max = Math.max(max, prev + next.getDistance());
                dfs(start, next, prev + next.getDistance());
            }
        }
    }
}
