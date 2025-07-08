package boj_2675;

import java.util.*;
import java.io.*;

public class Main {
    public static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            char[] charArray = s.toCharArray();

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    sb.append(charArray[j]);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
