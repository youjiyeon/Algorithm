import java.io.*;
import java.util.*;

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
        
        int ans = dp[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}