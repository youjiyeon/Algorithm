/*
0부터 n-1까지 * n-1부터 0까지
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[36];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0, k = i-1; j < i && k>=0 ; j++, k--) {
                dp[i] += (dp[j])*(dp[k]);
            }
        }
        System.out.println(dp[n]);
    }
}