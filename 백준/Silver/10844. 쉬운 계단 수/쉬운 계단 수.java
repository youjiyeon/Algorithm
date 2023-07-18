import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];

        // 첫번째 자리수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개임
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 두번째 자릿수부터 n번째 자리수까지 탐색
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {

                // 0, 9일 때 이전 자릿수의 1, 8만 가능
                if (j==0){
                    dp[i][j] = dp[i-1][1] % mod;
                }
                else if (j==9) {
                    dp[i][9] = dp[i-1][8] % mod;
                }
                // 1씩 차이나는 j-1과 j+1의 합
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result+=dp[n][i];
        }

        System.out.println(result % mod);
    }
}