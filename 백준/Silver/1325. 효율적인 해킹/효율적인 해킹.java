import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static List<Integer>[] list;
    public static int[] cnt;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            visit[i] = true;
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, cnt[i]);
        }

        for (int i = 1; i <= N; i++) {
            if(max==cnt[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int n) {

        for (int next: list[n]) {
            if(!visit[next]){
                cnt[next]++;
                visit[next] = true;
                dfs(next);
            }
        }
    }
}