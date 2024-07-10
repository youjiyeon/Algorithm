import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int c;
        int s;

        public Node(int idx, int c, int s) {
            this.idx = idx;
            this.c = c;
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            return this.s - o.s;
        }
    }
    static int n;
    static Node[] node;
    static long[] sum, ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        node = new Node[n];
        sum = new long[n+1];
        ans = new long[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            node[i] = new Node(i, c, s);
        }

        Arrays.sort(node);

        int tmp = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            Node cur = node[i];
            while (node[idx].s < cur.s) {
                tmp += node[idx].s;
                sum[node[idx].c] += node[idx].s;
                idx++;
            }
            ans[node[i].idx] = tmp - sum[cur.c];
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.print(sb);
    }
}