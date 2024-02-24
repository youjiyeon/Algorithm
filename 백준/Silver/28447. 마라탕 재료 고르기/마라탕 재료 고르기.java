import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, ans = Integer.MIN_VALUE;
    public static int[] pick;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        pick = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        com(0, 0);
        System.out.println(ans);
    }

    public static void com(int cnt, int start) {
        if (cnt == k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                int tmp = Integer.MIN_VALUE;
                for (int j = i+1; j < k; j++) {
                    sum+=map[pick[i]][pick[j]];
                }
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = start; i < n; i++) {
            pick[cnt] = i;
            com(cnt+1, i+1);
        }
    }
}
