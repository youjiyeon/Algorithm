import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            
            if (dp[n]==0) {
                for (int j = 4; j <= n; j++) {
                    if (dp[j]!=0) continue;
                    dp[j] = dp[j-3]+dp[j-2]+dp[j-1];
                }
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}