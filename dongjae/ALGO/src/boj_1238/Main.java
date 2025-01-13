package boj_1238;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int end;
    private int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    public int getEnd() {
        return this.end;
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
    public static int n, m;
    public static int[] distance;
    public static boolean[] visited;
    public static int[] prev;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n+1];
        visited = new boolean[n+1];
        prev = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        StringBuilder sb = new StringBuilder();
        sb.append(distance[to]).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(to);
        int count = 1;
        while (prev[to] != 0) {
            count++;
            to = prev[to];
            stack.push(to);
        }

        sb.append(count).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.getEnd()]) {
                for (int i = 0; i < graph.get(now.getEnd()).size(); i++) {
                    Node next = graph.get(now.getEnd()).get(i);
                    if (distance[next.getEnd()] > distance[now.getEnd()] + next.getCost()) {
                        distance[next.getEnd()] = distance[now.getEnd()] + next.getCost();
                        prev[next.getEnd()] = now.getEnd();
                        pq.offer(new Node(next.getEnd(), distance[next.getEnd()]));
                    }
                }
                visited[now.getEnd()] = true;
            }
        }
    }
}