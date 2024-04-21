import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] coin;
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new long[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i-coin[j]>=0)
                    dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}