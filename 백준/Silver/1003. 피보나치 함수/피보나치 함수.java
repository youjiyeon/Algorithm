import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[41][2];

        // 초기값 세팅
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n][0]==0 && dp[n][1]==0) {
                for (int i = 2; i <= n; i++) {
                    if(dp[i][0]!=0 || dp[i][1]!=0) continue;
                    dp[i][0] = dp[i-1][0]+dp[i-2][0];
                    dp[i][1] = dp[i-1][1]+dp[i-2][1];
                }
            }
            sb.append(dp[n][0]+" "+dp[n][1]+"\n");
        }
        System.out.println(sb);
    }
}