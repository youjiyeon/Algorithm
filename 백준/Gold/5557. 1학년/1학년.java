import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] map;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N];
        dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][map[0]] = 1;
        int plus;
        int minus;
        for(int i=1; i<N-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    plus = j+map[i];
                    minus = j-map[i];
                    if(plus>=0 && plus<=20){
                        dp[i][plus]+=dp[i-1][j];
                    }
                    if(minus>=0 && minus<=20){
                        dp[i][minus]+=dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][map[N-1]]);
    }
}