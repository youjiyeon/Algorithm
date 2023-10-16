import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static int[][] dp = new int[1000001][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 1000000; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        makeOne(N, N, 0);
        System.out.println(dp[1][0]);

        int cur = 1;
        List<Integer> list = new ArrayList<>();
        while (true){
            list.add(cur);
            if (cur==N){
                break;
            }
            cur = dp[cur][1];
        }
        Collections.reverse(list);
        for (int i: list) {
            System.out.print(i+" ");
        }
    }

    public static void makeOne(int prev, int num, int cnt){

        if (dp[num][0]<cnt)
            return;

        if (dp[num][0] > cnt){
            dp[num][0] = cnt;
            dp[num][1] = prev;
        }

        if (num%3==0){
            makeOne(num, num/3, cnt+1);
        }

        if (num%2==0){
            makeOne(num, num/2, cnt+1);
        }

        if (num-1>0) {
            makeOne(num, num-1, cnt+1);
        }
    }
}