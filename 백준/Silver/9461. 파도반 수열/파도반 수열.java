import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 초기값 설정
        long[] dp = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            if(dp[n]==0){
                for (int i = 6; i <= n; i++) {
                    if(dp[i]!=0) continue;
                    dp[i] = dp[i-2]+dp[i-3];
                }
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}