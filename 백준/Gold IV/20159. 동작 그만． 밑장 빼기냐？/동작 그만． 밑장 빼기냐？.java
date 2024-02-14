import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1[N-1] = arr[N-1];
        dp1[N-2] = arr[N-2];
        for (int i = N-3; i>=0; i--) {
            dp1[i] = dp1[i+2]+arr[i];
        }

        dp2[0] = arr[0];
        dp2[1] = arr[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = dp2[i-2]+arr[i];
        }

        long max = Math.max(dp1[1], arr[0]+dp1[1]-arr[N-1]);

        for (int i = 2; i < N; i++) {
            if (i%2==0) {
                max = Math.max(max, dp2[i-2]+dp1[i+1]);
            }
            else {
                max = Math.max(max, dp2[i-1] + dp1[i]-arr[N-1]);
            }
        }
        
        long sum = dp1[0];
        max = Math.max(sum,max);
        System.out.println(max);
    }
}