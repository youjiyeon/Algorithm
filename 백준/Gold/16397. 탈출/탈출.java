import java.io.*;
import java.util.*;

public class Main {
    public static int N, T, G;
    public static boolean[] v;
    public static int[] click;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        v = new boolean[100000];
        click = new int[100000];
        int ans = bfs(N);
        System.out.println(ans == -1 ? "ANG" : ans);
    }

    public static int bfs(int i) {
        int len = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        v[i] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            if (len > T) return -1;

            while (size-- > 0) {
                int cur = q.poll();
                //System.out.println(cur);

                if (cur == G) return len;

                if (cur + 1 <= 99999 && !v[cur+1]) {
                    q.offer(cur + 1);
                    v[cur+1] = true;
                }
                if (cur * 2 <= 99999 && cur!=0) {
                    int tmp = b(cur * 2);

                    if (!v[tmp]) {
                        q.offer(tmp);
                        v[tmp] = true;
                    }
                }
            }
            len++;
        }

        return -1;
    }

    public static int b(int val) {
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(val);

        if ((str.charAt(0) - '0') - 1 >= 0) {
            sb.append((str.charAt(0) - '0') - 1);
        }
        for (int i = 1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }

        //System.out.println(val+" "+sb);
        return Integer.parseInt(String.valueOf(sb));
    }
}