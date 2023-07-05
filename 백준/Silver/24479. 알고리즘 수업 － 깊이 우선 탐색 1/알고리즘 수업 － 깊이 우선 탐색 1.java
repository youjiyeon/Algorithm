import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, start;
    public static List<Integer>[] list;
    public static int[] order;
    public static boolean[] visit;
    public static List<Integer> o;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        o = new ArrayList<>();
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

        visit = new boolean[N+1];
        visit[start] = true;
        dfs(start);

        for (int i = 0; i < o.size(); i++) {
            order[o.get(i)] = i+1;
        }
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]+"\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int n) {
        o.add(n);
        for (int next: list[n]) {
            if(!visit[next]){
                visit[next] = true;
                dfs(next);
            }
        }
    }
}