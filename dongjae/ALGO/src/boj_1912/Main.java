package boj_1912;

import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] array;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
