package boj_2473;

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

        long min = Long.MAX_VALUE;
        int[] result = new int[3];

        for (int i = 0; i < n - 2; i++) {
            int a1 = array.get(i);
            int startIdx = i + 1;
            int endIdx = n - 1;
            while (startIdx < endIdx) {
                long sum = (long) a1 + array.get(startIdx) + array.get(endIdx);
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result[0] = a1;
                    result[1] = array.get(startIdx);
                    result[2] = array.get(endIdx);
                }

                if (sum < 0) startIdx++;
                else if (sum == 0) break;
                else endIdx--;
            }
        }

        Arrays.sort(result);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
