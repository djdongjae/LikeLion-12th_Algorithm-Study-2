package boj_2512;

import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> nlist = new ArrayList<>();
    public static long m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nlist.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());

        Collections.sort(nlist);

        int result = binarySearch(1, nlist.get(nlist.size() - 1));
        System.out.println(result);
    }

    public static int binarySearch(int start, int end) {
        if (start > end) {
            return end;
        }
        int mid = (start + end) / 2;
        if (check(mid) > m) {
            return binarySearch(start, mid - 1);
        } else {
            return binarySearch(mid + 1, end);
        }
    }

    public static long check(int limit) {
        long sum = 0;
        for (int i = 0; i < nlist.size(); i++) {
            if (limit > nlist.get(i)) sum += nlist.get(i);
            else sum += limit;
        }
        return sum;
    }
}
