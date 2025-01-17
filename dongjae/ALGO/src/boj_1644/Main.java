package boj_1644;

import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 소수 배열 채우기
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) primes.add(i);
        }

        // 연속합 구하기
        int start = 0, end = 0;
        int count = 0;
        int sum = 0;

        while (true) {
            if (sum >= n) {
                if (sum == n) count++;
                if (start < primes.size()) {
                    sum -= primes.get(start);
                    start++;
                } else {
                    break;
                }
            } else {
                if (end < primes.size()) {
                    sum += primes.get(end);
                    end++;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
