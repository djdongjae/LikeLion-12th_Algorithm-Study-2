package boj_1976;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] parent;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] travelList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        travelList = new int[m];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = null;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (st.nextToken().equals("1")) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            travelList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                unionParent(i, graph.get(i).get(j));
            }
        }

        boolean flag = false;
        for (int i = 0; i < (m - 1); i++) {
            int from = travelList[i];
            int to = travelList[i + 1];
            if (findParent(from) == findParent(to)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
