import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, min, ans = 0;
    public static int[] money;
    public static List<Integer>[] list;
    public static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        v = new boolean[n+1];
        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        money = new int[n+1];
        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                v[i] = true;
                min = Integer.MAX_VALUE;
                dfs(i);
                ans += min;
            }
        }

        System.out.println(ans > k ? "Oh no" : ans);
    }

    public static void dfs(int node) {
        min = Math.min(min, money[node]);

        for (int i = 0; i < list[node].size(); i++) {
            if (!v[list[node].get(i)]) {
                v[list[node].get(i)] = true;
                dfs(list[node].get(i));
            }
        }
    }
}