import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {

            dp[i] = arr[i];

            for(int j=0;j<i;j++) { // 첫 번째 부터 i이전 까지 비교를 위한 반복
                if(arr[i]>arr[j]) { // 기준값이 더 큰 경우
                    dp[i] = Math.max(dp[j]+arr[i],dp[i]); // 증가 수열이므로 dp값 갱신
                }
            }

            max = Math.max(max, dp[i]);

        }

        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}