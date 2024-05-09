import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        StringBuilder sb  = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        lists = new List[N+1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }

        recur(R, 0);

        for (int i = 0; i < Q; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }

    static void recur(int cur, int prev) {
        dp[cur] = 1;

        for (int next : lists[cur]) {
            if (next != prev) {
                recur(next, cur);
                dp[cur] += dp[next];
            }
        }
    }
}