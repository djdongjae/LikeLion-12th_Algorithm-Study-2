package boj_1167;

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
    public static int v;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int farthestNode, maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());

        visited = new boolean[v+1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                int y = Integer.parseInt(st.nextToken());

                graph.get(num).add(new Node(x, y));
            }
        }

        visited = new boolean[v + 1];
        maxDistance = 0;
        dfs(1, 0);

        visited = new boolean[v + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    public static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDistance) {
            maxDistance = dist;
            farthestNode = node;
        }

        for (Node next : graph.get(node)) {
            if (!visited[next.getX()]) {
                dfs(next.getX(), dist + next.getDistance());
            }
        }
    }
}
