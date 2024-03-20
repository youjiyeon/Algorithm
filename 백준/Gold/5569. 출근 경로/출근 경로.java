import java.io.*;
import java.util.*;

public class Main {
    public static final int MOD = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // x, y, 방향(0: 오른쪽, 1: 아래), 방향 전환 유무(0: X, 1: O)
        int[][][][] dp = new int[w+1][h+1][2][2];

        // 직진은 1
        for (int i = 1; i <= w; i++) {
            dp[i][1][0][0] = 1;
        }
        for (int i = 1; i <= h; i++) {
            dp[1][i][1][0] = 1;
        }

        // 1 1 1
        // 1
        // 1
        // 1

        for (int i = 2; i <= w; i++) {
            for (int j = 2; j <= h; j++) {
                dp[i][j][1][0] = (dp[i][j-1][1][1]+dp[i][j-1][1][0]) % MOD;
                dp[i][j][1][1] = dp[i][j-1][0][0] % MOD;
                dp[i][j][0][0] = (dp[i-1][j][0][0]+dp[i-1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i-1][j][1][0] % MOD;
            }
        }

        int ans = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % MOD;
        System.out.println(ans);
    }
}
