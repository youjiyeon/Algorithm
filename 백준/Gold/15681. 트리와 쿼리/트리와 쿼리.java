import java.io.*;
import java.util.*;
public class Main {
    public static int[] cnt;
    public static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        cnt = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        dfs(R, -1);
        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(cnt[node]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int cur, int prv) {
        cnt[cur] = 1;

        for (int i : list[cur]) {
            if (i != prv) {
                dfs(i, cur);
            }
        }

        if (prv!=-1) {
            cnt[prv]+=cnt[cur];
        }
    }
}