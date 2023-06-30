import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Integer[] dp;
    public static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        map = new int[n+1];

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = map[0];
        dp[1] = map[1];

        if(n>=2){
            dp[2] = map[1] + map[2];
        }

        System.out.println(find(n));
        
    }

    public static int find(int n){
        if(dp[n] == null){
            dp[n] = Math.max(find(n-2),find(n-3)+map[n-1])+map[n];
        }
        return dp[n];
    }
}