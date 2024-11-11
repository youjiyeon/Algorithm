import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] isSheep;
    static long[] val;
    static List<Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        isSheep = new boolean[n+1];
        val = new long[n+1];

        map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            long num = Long.parseLong(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            // 양인지 체크
            if (c == 'S') {
                isSheep[i] = true;
            }

            val[i] = num;
            map[start].add(i);
        }

        System.out.println(dfs(1));
    }

    static long dfs(int idx) {
        long num = 0;

        for (int next : map[idx]) {
            num += dfs(next);
        }

        // 도착지 도달
        if (idx == 1) {
            return num;
        }

        if (isSheep[idx]) {
            num += val[idx];
        }
        else {
            num = num - val[idx] < 0 ? 0 : num - val[idx];
        }

        return num;
    }
}