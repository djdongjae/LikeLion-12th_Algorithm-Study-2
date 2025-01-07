package boj_1939;

import java.io.*;
import java.util.*;

class Node {
    private int destination;
    private long distance;

    public Node(int destination, long distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public int getDestination() {
        return this.destination;
    }

    public long getDistance() {
        return this.distance;
    }
}

public class Main {
    public static int n, m;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int from, to;
    public static boolean[] visited;
    public static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));

            max = Math.max(c, max);
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        long answer = binarySearch(0, max);
        System.out.println(answer);
    }

    public static boolean dfs(int now, long limit) {
        visited[now] = true;
        if (now == to) {
            return true;
        }
        for (int i = 0; i < graph.get(now).size(); i++) {
            Node next = graph.get(now).get(i);
            if (!visited[next.getDestination()] && next.getDistance() >= limit) {
                if(dfs(next.getDestination(), limit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long binarySearch(long start, long end) {
        while (start <= end) {
            long mid = (start + end) / 2;
            visited = new boolean[n+1];
            if (dfs(from, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
