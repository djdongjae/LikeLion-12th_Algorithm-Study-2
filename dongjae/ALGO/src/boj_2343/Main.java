package boj_2343;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] array;
    public static int max;
    public static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];

        max = 0;
        sum = 0L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            array[i] = now;
            max = Math.max(now, max);
            sum += now;
        }

        System.out.println(binarySearch(max, sum));
    }

    public static long binarySearch(long start, long end) {
        while (start <= end) {
            long mid = (start + end) / 2;
            if (check(mid) > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int check(long x) {
        int count = 0;
        long subSum = 0;
        for (int i = 0; i < n; i++) {
            subSum += array[i];
            if (subSum > x) {
                subSum = array[i];
                count++;
            } else if (subSum == x) {
                subSum = 0;
                count++;
            }
        }
        if (subSum != 0) count++;
        return count;
    }
}
