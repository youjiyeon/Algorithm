import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long gcd = 0L;
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[t];
            for (int j = 0; j < t; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < t; j++) {
                for (int k = j+1; k < t; k++) {
                    if (j==k) continue;
                    gcd += getGCD(Math.max(arr[j], arr[k]), Math.min(arr[j], arr[k]));
                }
            }
            sb.append(gcd).append("\n");
        }

        System.out.print(sb);
    }

    static long getGCD(long a, long b) {
        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }

        return a;
    }
}