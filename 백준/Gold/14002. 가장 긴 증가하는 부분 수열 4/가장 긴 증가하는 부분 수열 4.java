import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        dp[0] = 1;
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            // 증가하는 수라면
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]){
                    // 길이를 늘려준다
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        List<Integer> result = new ArrayList<>();
        int temp = max;
        for (int i = N-1; i >= 0; i--) {
            if(dp[i]==temp){
                result.add(arr[i]);
                temp--;
            }
        }

        System.out.println(max);
        Collections.sort(result);
        for (int i: result) {
            System.out.print(i+" ");
        }
    }
}