import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==0){
            System.out.println(0);
            System.exit(0);
        }
        dp = new BigInteger[N+1];

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-2].add(dp[i-1]);
        }
        System.out.println(dp[N]);
    }
}