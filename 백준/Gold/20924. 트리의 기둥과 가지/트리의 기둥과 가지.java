import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node;
        int dis;
        public Node(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    static int n, r, rLen = 0, max = 0, giga;
    static List<Node>[] list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

       if (n != 1) {
           visit = new boolean[n+1];
           pillarDfs(r, 0);
           dfs(giga, 0);
       }

        System.out.println(rLen+" "+max);
    }

    static void pillarDfs(int node, int sum) {
        if (list[node].size() > 2 || (list[node].size() == 1 && node != r) || (list[node].size() == 2 && node == r)) {
            rLen = sum;
            giga = node;
            return;
        }

        for (Node next : list[node]) {
            if (!visit[next.node]) {
                visit[next.node] = true;
                pillarDfs(next.node, sum+next.dis);
            }
        }
    }

    static void dfs(int node, int sum) {
        if (list[node].size() == 1) {
            max = Math.max(max, sum);
            return;
        }

        for (Node next : list[node]) {
            if (!visit[next.node]) {
                visit[node] = true;
                dfs(next.node, sum+next.dis);
                visit[node] = false;
            }
        }
    }
}