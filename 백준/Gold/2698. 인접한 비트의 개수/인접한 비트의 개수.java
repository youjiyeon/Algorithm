import java.io.*;
import java.util.*;

public class Main {

    static int n, k, ans;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new int[100][100][2];

        while (t-- > 0) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            System.out.println(loop(0, 0, 0));
        }
    }

    static int loop(int cnt, int val, int pre) {
        if (cnt >= n) {
            if (val == k) {
                return 1;
            }
            return 0;
        }

        if (dp[cnt][val][pre] != -1) return dp[cnt][val][pre];

        dp[cnt][val][pre] = 0;

        dp[cnt][val][pre] += loop(cnt+1, val+(pre*pre), pre);
        if (pre == 1)
            dp[cnt][val][pre] += loop(cnt+1, val, 0);
        else
            dp[cnt][val][pre] += loop(cnt+1, val, 1);

        return dp[cnt][val][pre];
    }
}