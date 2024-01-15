import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] arr = br.readLine().split(" ");
            int n = arr.length;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    max = Math.max(max, gcd(Integer.parseInt(arr[i]), Integer.parseInt(arr[j])));
                }
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (b!=0){
            int tmp = a%b;
            a=b;
            b = tmp;
        }
        return a;
    }

    static long five(long n) {
        int cnt = 0;

        while (n >= 5) {
            cnt += (n / 5);
            n /= 5;
        }
        return cnt;
    }
}