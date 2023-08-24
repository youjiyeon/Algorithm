import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int day;
        int money;
        public Node(int day, int money) {
            this.day = day;
            this.money = money;
        }

    }
    public static int N, max = Integer.MIN_VALUE;
    public static Node[] schedule;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그래프 입력
        schedule = new Node[N+1];
        dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            schedule[i] = new Node(d, m);
        }

        for(int i = N; i >= 1; i--){
            if(i + schedule[i].day > N+1){ //날짜  초과
                dp[i] = dp[i+1];
            }
            else{ //날짜 초과 X
                dp[i] = Math.max(dp[i+1], schedule[i].money + dp[i+schedule[i].day]);
            }
        }

        System.out.println(dp[1]);

        //dfs(1, 0);
        //System.out.println(max);
    }

    // 선택을 하거나 안하거나
    // 선택을 한다면 +n.money
    // 선택을 안한다면 +1
    public static void dfs(int d, int m){
        if (d==N+1){
            max = Math.max(max, m);
            return;
        }

        // 선택 O
        if (d+schedule[d].day<=N+1){
            dfs(d+schedule[d].day, m+schedule[d].money);
        }

        // 선택 X
        dfs(d+1, m);
    }
}
