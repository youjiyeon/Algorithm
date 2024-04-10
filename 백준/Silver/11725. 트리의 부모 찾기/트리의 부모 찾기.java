import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] ans;
    public static boolean[] v;
    public static List[] lists;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new List[N+1];
        v = new boolean[N+1];
        ans = new int[N+1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            lists[m].add(n);
            lists[n].add(m);
        }

        for (int i = 1; i <= N; i++) {
            v[1] = true;
            dfs(1);
        }

        for (int i = 2; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int start){
        for (int i = 0; i < lists[start].size(); i++) {
            if (!v[(int)lists[start].get(i)]) {
                v[(int)lists[start].get(i)] = true;
                ans[(int)lists[start].get(i)] = start;
                dfs((int)lists[start].get(i));
            }
        }
    }
}