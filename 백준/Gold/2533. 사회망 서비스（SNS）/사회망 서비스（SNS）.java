import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] lists;
    static boolean[] v;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][2];
        lists = new List[N+1];
        v = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }

        recur(1);

        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }

    public static void recur(int num) {
        v[num] = true;
        // 얼리어답터가 아닌 경우, 생략 가능
        dp[num][0] = 0;
        // 얼리어답터인 경우
        dp[num][1] = 1;

        for (int next : lists[num]) {
            if (!v[next]) {
                recur(next);
                // num이 얼리어답터가 아니라면 자식은 무조건 얼리어답터여야 함
                dp[num][0] += dp[next][1];
                // num이 얼리어답터라면 자식은 얼리어답터가 아니여도 상관없으니
                // 둘 중 작은 값
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}