import java.io.*;
import java.util.*;

public class Main {
    public static int n, cnt = 0;
    public static int[][] arr;
    public static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        v = new boolean[n+1];
        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        v[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int node) {
        for (int i = 1; i <= n; i++) {
            if (!v[i] && arr[node][i] == 1) {
                cnt++;
                v[i] = true;
                dfs(i);
            }
        }
    }
}