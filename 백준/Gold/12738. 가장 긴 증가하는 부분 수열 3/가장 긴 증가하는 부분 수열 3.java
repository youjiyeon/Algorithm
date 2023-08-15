import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] num;
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        dp[0] = num[0];
        int i = 1;

        while (i<N){
            if (dp[j]<num[i]){
                dp[j+1] = num[i];
                j++;
            }
            else {
                int idx = bs(0,j,num[i]);
                dp[idx] = num[i];
            }
            i++;
        }
        System.out.println(j+1);
    }

    private static int bs(int l, int r, int target) {
        int mid = 0;
        while (l<r){
            mid = (l+r)/2;
            if (dp[mid]<target){
                l = mid+1;
            }
            else r = mid;
        }
        return l;
    }
}
