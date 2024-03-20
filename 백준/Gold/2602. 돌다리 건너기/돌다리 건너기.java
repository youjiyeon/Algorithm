import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String a = br.readLine();
        String b = br.readLine();

        int[][][] dp = new int[2][str.length()][a.length()];

        if (str.charAt(0) == a.charAt(0)) {
            dp[0][0][0] = 1;
        }
        if (str.charAt(0) == b.charAt(0)) {
            dp[1][0][0] = 1;
        }

        for (int i = 1; i < a.length(); i++) {
            char tmpA = a.charAt(i);
            char tmpB = b.charAt(i);

            dp[0][0][i] = dp[0][0][i-1];
            dp[1][0][i] = dp[1][0][i-1];

            if (str.charAt(0) == tmpA) {
                dp[0][0][i]++;
            }
            if (str.charAt(0) == tmpB) {
                dp[1][0][i]++;
            }

            for (int j = 1; j < str.length(); j++) {
                dp[0][j][i] += dp[0][j][i-1];
                dp[1][j][i] += dp[1][j][i-1];

                if (str.charAt(j) == tmpA) {
                    dp[0][j][i] += dp[1][j - 1][i - 1];
                }
                if (str.charAt(j) == tmpB) {
                    dp[1][j][i] += dp[0][j - 1][i - 1];
                }
            }
        }

        System.out.println(dp[0][str.length()-1][a.length()-1] + dp[1][str.length()-1][a.length()-1]);
    }
}