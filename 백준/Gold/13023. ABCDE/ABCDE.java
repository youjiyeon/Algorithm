import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, cnt;
    public static List<Integer>[] list;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[to].add(from);
            list[from].add(to);
        }

        // 각 자리마다 dfs로 cnt세기
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            dfs(i, 0);
        }
        System.out.println(0);
    }

    public static void dfs(int n, int len){
        if (len==4){
            System.out.println(1);
            System.exit(0);
        }
        visit[n] = true;
        for (int i = 0; i < list[n].size(); i++) {
            if(!visit[list[n].get(i)]){
                visit[list[n].get(i)] = true;
                dfs(list[n].get(i), len+1);
                visit[list[n].get(i)] = false;
            }
        }

    }
}