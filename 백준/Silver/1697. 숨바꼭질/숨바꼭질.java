import java.util.*;
import java.io.*;

public class Main {
    static boolean[] v = new boolean[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(bfs(s, e));
    }

    static int bfs(int s, int e) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        v[s] = true;

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();

                if (cur == e) {
                    return level;
                }

                int tmp1 = cur-1;
                int tmp2 = cur+1;
                int tmp3 = cur*2;

                if (tmp1 >= 0 && tmp1 <= 100000 && !v[tmp1]) {
                    q.offer(tmp1);
                    v[tmp1] = true;
                }
                if (tmp2 >= 0 && tmp2 <= 100000 && !v[tmp2]) {
                    q.offer(tmp2);
                    v[tmp2] = true;
                }
                if (tmp3 >= 0 && tmp3 <= 100000 && !v[tmp3]) {
                    q.offer(tmp3);
                    v[tmp3] = true;
                }
            }
            level++;
        }
        return level;
    }
}