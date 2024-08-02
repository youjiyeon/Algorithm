import java.io.*;
import java.util.*;

public class Main {
    static int k, n, f;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < f; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int[] pick = new int[k];
        if (!dfs(0, pick, 0)) {
            System.out.println(-1);
        }
    }

    static boolean dfs(int cnt, int[] pick, int cur) {
        if (cnt == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(pick[i]).append("\n");
            }
            System.out.print(sb);
            return true;
        }

        for (int i = cur+1; i <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < cnt; j++) {
                if (!list[i].contains(pick[j])) {
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;

            pick[cnt] = i;
            if (dfs(cnt+1, pick, i)) return true;
        }

        return false;
    }
}