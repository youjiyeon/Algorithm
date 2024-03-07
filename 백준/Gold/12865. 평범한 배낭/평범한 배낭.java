import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static Integer[][] bag, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bag = new Integer[n][2];
        dp = new Integer[n][k+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(n-1, k));
    }

    public static int dp(int idx, int k) {
        if (idx<0) {
            return 0;
        }

        if (dp[idx][k] == null) {
            if (bag[idx][0] > k) {
                dp[idx][k] = dp(idx-1, k);
            }
            else {
                dp[idx][k] = Math.max(dp(idx-1, k), dp(idx-1, k-bag[idx][0])+bag[idx][1]);
            }
        }
        return dp[idx][k];
    }
}