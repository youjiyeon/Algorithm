import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            
            if(dp[n]==0) {
                for (int i = 4; i <= n; i++) {
                    if(dp[i]!=0)
                        continue;
                    dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
                }
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}