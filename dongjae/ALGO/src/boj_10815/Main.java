package boj_10815;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer> nlist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nlist.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nlist);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int result = binarySearch(target) ? 1 : 0;
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int target) {
        int start = 0;
        int end = nlist.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nlist.get(mid) == target) {
                return true;
            } else if (nlist.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}