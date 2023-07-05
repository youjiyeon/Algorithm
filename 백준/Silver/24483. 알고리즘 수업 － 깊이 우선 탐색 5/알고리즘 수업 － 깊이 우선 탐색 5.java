import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, start, cnt = 0;
    public static List<Integer>[] list;
    public static int[] order, visit;
    public static long sum = 0l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        order = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        visit = new int[N+1];
        Arrays.fill(visit, -1);
        visit[start] = 0;
        dfs(start, 0);

        System.out.println(sum);
    }

    public static void dfs(int n, int depth) {
        visit[n] = depth;
        order[n] = ++cnt;
        sum+=(long) order[n]*depth;
        for (int next: list[n]) {
            if(visit[next]!=-1){
                continue;
            }
            dfs(next, depth+1);
        }
    }
}