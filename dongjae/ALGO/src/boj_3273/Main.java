package boj_3273;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, x;
    public static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array.add(num);
        }

        x = Integer.parseInt(br.readLine());

        Collections.sort(array);

        int startIdx = 0;
        int endIdx = n - 1;
        int count = 0;

        while (startIdx < endIdx) {
            int a1 = array.get(startIdx);
            int a2 = array.get(endIdx);
            int sum = a1 + a2;
            if (sum >= x) {
                if (sum == x) {
                    count++;
                }
                endIdx--;
            } else {
                startIdx++;
            }
        }

        System.out.println(count);
    }
}