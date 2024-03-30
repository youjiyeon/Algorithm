import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, ans = -1;
    public static int[] wok, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        wok = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            wok[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        bfs();

        System.out.println(ans);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        dp[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 0) {
                ans = dp[0];
                return;
            }

            for (int i = 0; i <= M; i++) {
                for (int j = i+1; j <= M; j++) {
                    int tmp = cur-wok[i]-wok[j];

                    if (tmp >= 0 && (dp[tmp] > dp[cur]+1)) {
                        q.offer(tmp);
                        dp[tmp] = dp[cur]+1;
                    }
                }
            }
        }
    }
}