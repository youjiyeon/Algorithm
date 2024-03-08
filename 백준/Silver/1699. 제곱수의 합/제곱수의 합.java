import java.io.*;

public class Main {
    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 1;
        System.out.println(dp(n));
    }

    public static int dp(int x) {
        if (dp[x] > 0 || x == 1) {
            return dp[x];
        }

        dp[x] = x;

        for (int i = 1; i*i <= x; i++) {
            dp[x] = Math.min(dp[x], dp(x-(i*i))+1);
        }

        return dp[x];
    }
}