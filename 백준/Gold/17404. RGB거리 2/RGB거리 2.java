import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = 10000001;
    static int[][] house, dp;

    public static void main(String[] args) throws NumberFormatException, IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // house[3][0] 2번째 집의 빨강 가격
        house = new int[N+1][3];
        dp = new int[N+1][3];

        // 집 페인트 가격 입력
        // 이전의 다른 색깔과의 합 중 적은 것 입력으로 넣기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) { // 처음 칠한 집의 색상
            for (int j = 0; j < 3; j++) dp[1][j] = i == j ? house[1][j] : 10000001;

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + house[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + house[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + house[j][2];
            }

            for(int j = 0; j < 3; j++) {
                if(i != j) result = Math.min(dp[N][j], result);
            }
        }

        System.out.println(result);
    }

}
