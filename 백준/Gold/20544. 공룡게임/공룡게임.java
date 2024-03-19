import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[][] dp = new long[1002][2];
    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine())+1;

        // 2 유무
        dp[0][0] = 0;
        dp[0][1] = 1;

        dp[1][0] = 1;
        dp[1][1] = 0;

        dp[2][0] = 1;
        dp[2][1] = 0;

        dp[3][0] = 2;
        dp[3][1] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % MOD;
            dp[i][1] = (dp[i-1][1] + dp[i-2][0] + dp[i-2][1]*2 + dp[i-3][0]*2 + dp[i-3][1]*3) % MOD;
        }

        System.out.println(dp[n][1]);
    }
}