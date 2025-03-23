import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[10001][4];
        int T = Integer.parseInt(br.readLine());

        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int j = 4; j <= 10000; j++) {
            dp[j][1] = dp[j-1][1];
            dp[j][2] = dp[j-2][1] + dp[j-2][2];
            dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];
        }

        // dp[n][1] -> 1로 만들수있는 경우
        // dp[n][1] = dp[n-1][1]; // 합이 n이고 1로 끝나는 경우의 수 중에 오름차순인 경우이므로 합이 n-1이고 1로 끝나는 경우에 1을 더하는 것만 가능하다.
        // dp[n][2] = dp[n-2][1] + dp[n-2][2]; // 합이 n이고 2로 끝나는 경우의 수 중에 오름차순인 경우이므로 합이 n-2이고 1로 끝나는 경우와 합이 n-2이고 2로 끝나는 경우에 2를 더하는 것이 가능하다.
        // dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]; // 뒤에 붙는 3은 1, 2, 3 중 최대이므로 합이 n-3인 모든 경우의 수 뒤에 3을 더하는 것이 가능하다.

        // 4를 예시로
        // [3][1] -> 3+1 = 4
        // [2][1]+[2][2] -> 2+1+1, 2+2 = 4
        // [1][1]+[1][2]+[1][3] -> 1+3 = 4
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");
        }

        System.out.println(sb);
    }
}