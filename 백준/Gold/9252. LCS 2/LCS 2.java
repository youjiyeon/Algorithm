import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();
        dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
        toString(a, n, m);
        System.out.println(sb.reverse());
    }

    static void toString(String str, int i, int j) {
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            }
            else if (dp[i][j] == dp[i][j-1]) {
                j--;
            }
            else {
                sb.append(str.charAt(i-1));
                i--;
                j--;
            }
        }
    }
}