import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1; dp[2] = 2; dp[3] = 3; dp[4] = 5;

        for (int i = 5; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }
        System.out.println(dp[n]);
    }
}