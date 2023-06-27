import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_13301_Main {
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        dp = new long[input+1];
        dp[0] = 2;
        dp[1] = 4;

        for (int i = 2; i <= input; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        System.out.println(dp[input]);
    }
}
