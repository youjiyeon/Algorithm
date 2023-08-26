import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void dfs(int node){
        discovered[node] = node_order++;

        if (discovered[next_node[node]]==-1){
                dfs(next_node[node]);
        } else if (!finish[next_node[node]]) {
            cycle += discovered[node] - discovered[next_node[node]] +1;
        }
        finish[node] = true;
    }

    public static int N, cnt, node_order, cycle;
    public static int[] next_node;
    public static boolean[] finish;
    public static int[] discovered;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cnt = 0;
            node_order = 0;
            cycle = 0;
            N = Integer.parseInt(br.readLine());
            finish = new boolean[N+1];
            discovered = new int[N+1];
            Arrays.fill(discovered, -1);
            next_node = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                next_node[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                if (!finish[j])
                    dfs(j);
            }

            System.out.println(N-cycle);
        }

    }

}