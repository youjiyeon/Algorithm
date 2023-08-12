import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] great, result;
    public static boolean[] visit;
    public static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        list = new List[N+1];
        great = new int[N+1];
        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p!=-1){
                list[p].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            great[node] += val;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]){
                dfs(i);
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]+" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        visit[node] = true;
        result[node]+=great[node];
        for (int i = 0; i < list[node].size(); i++) {
            if (!visit[list[node].get(i)]){
                result[list[node].get(i)]+=result[node];
                dfs(list[node].get(i));
            }
        }
    }
}