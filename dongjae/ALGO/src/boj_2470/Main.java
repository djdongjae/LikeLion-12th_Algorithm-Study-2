package boj_2470;

import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array.add(num);
        }

        Collections.sort(array);

        int startIdx = 0;
        int endIdx = n - 1;
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;

        while (startIdx < endIdx) {
            int sum = array.get(startIdx) + array.get(endIdx);

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = array.get(startIdx);
                result[1] = array.get(endIdx);
            }

            if (sum > 0) endIdx--;
            else if (sum == 0) break;
            else startIdx++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.println(sb);
    }
}
