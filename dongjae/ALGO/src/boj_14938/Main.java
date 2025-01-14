package boj_14938;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) return -1;
        else if (this.distance == other.distance) return 0;
        else return 1;
    }
}

public class Main {
    public static int n, m, r;
    public static int[] items;
    public static int[][] d;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        d = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i+1] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                d[i+1][j+1] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(new Node(i, 0));
        }

        System.out.println(getMax());
    }

    public static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (d[i][j] <= m) {
                    sum += items[j];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(start);
        d[start.getIndex()][start.getIndex()] = 0;
        boolean[] visited = new boolean[n+1];
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.getIndex();
            if (!visited[index]) {
                for (int i = 0; i < graph.get(index).size(); i++) {
                    Node next = graph.get(index).get(i);
                    int cost = d[start.getIndex()][index] + next.getDistance();
                    if (d[start.getIndex()][next.getIndex()] > cost) {
                        d[start.getIndex()][next.getIndex()] = cost;
                        pq.offer(new Node(next.getIndex(), cost));
                    }
                }
                visited[index] = true;
            }
        }
    }
}
