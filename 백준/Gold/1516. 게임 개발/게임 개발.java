import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int idx;
        int time;
        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    public static int n;
    public static int[] d, t, ans;
    public static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new int[n+1];
        d = new int[n+1];
        t = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());
            while (tmp != -1) {
                list[tmp].add(i);
                d[i]++;

                tmp = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.offer(i);
                ans[i] = t[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                if (ans[cur]+t[next] > ans[next]) {
                    ans[next] = ans[cur]+t[next];
                }
                if (--d[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}