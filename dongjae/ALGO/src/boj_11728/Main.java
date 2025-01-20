package boj_11728;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arrayA, arrayB, newArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrayA = new int[n];
        arrayB = new int[m];
        newArray = new int[n+m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        int aIndex = 0;
        int bIndex = 0;
        int count = 0;

        while (aIndex < n && bIndex < m) {
            if (arrayA[aIndex] < arrayB[bIndex]) {
                newArray[count++] = arrayA[aIndex++];
            } else {
                newArray[count++] = arrayB[bIndex++];
            }
        }

        if (aIndex == n) {
            for (int i = bIndex; i < m; i++) {
                newArray[count++] = arrayB[i];
            }
        } else if (bIndex == m) {
            for (int i = aIndex; i < n; i++) {
                newArray[count++] = arrayA[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newArray.length; i++) {
            sb.append(newArray[i]).append(" ");
        }

        System.out.println(sb);
    }
}
