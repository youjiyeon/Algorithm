import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int sum = 0;

            int[] time = new int[n];
            int[] max = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                max[i] = time[i];
            }

            int[][] arr = new int[n][n];
            int[] in = new int[n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;

                arr[s][e] = 1;
                in[e]++;
            }
            int w = Integer.parseInt(br.readLine())-1;

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) q.offer(i);
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == w) break;
                //sum += time[cur];

                for (int i = 0; i < n; i++) {
                    if (arr[cur][i] == 1) {
                        max[i] = Math.max(max[i], max[cur]+time[i]);
                        in[i]--;
                        if (in[i] == 0) q.offer(i);
                    }
                }
            }

            sb.append(max[w]).append("\n");
        }

        System.out.print(sb);
    }
}