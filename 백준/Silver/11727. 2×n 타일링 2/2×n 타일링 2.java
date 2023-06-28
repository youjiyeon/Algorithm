import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 초기값 설정
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(dp[n]==0){
            for (int i = 4; i <= n; i++) {
                if(dp[i]!=0) continue;
                dp[i] = (dp[i-1]+(dp[i-2]*2))%10007;
            }
        }
        System.out.println(dp[n]);
    }
}
