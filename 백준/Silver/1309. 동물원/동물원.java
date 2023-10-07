import java.io.*;

public class Main
{
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[100001];
        dp[1] = 3;
        dp[2] = 7;
        dp[3] = 17;
        dp[4] = 41;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 5; i <= n; i++) {
            dp[i] = ((2*dp[i-1])+dp[i-2])%9901;
        }

        System.out.println(dp[n]%9901);
    }
}