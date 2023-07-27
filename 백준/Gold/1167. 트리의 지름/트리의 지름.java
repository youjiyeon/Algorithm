import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int next;
        int val;

        public Node(int next, int val){
            this.next = next;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", val=" + val +
                    '}';
        }
    }
    public static int N, max, node;
    public static int[] dp;
    public static List<Node>[] list;
    public static boolean[] visit;
    // 아래, 오른쪽
    public static int[][] way = {{1,0},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;

        list = new List[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next==-1){
                    break;
                }
                int val = Integer.parseInt(st.nextToken());
                list[v].add(new Node(next, val));
            }
        }

        visit = new boolean[N+1];
        dfs(1, 0);
        
        visit = new boolean[N+1];
        dfs(node, 0);
        
        System.out.println(max);
    }

    private static void dfs(int v, int sum) {
        visit[v] = true;
        if (max<sum){
            max = sum;
            node = v;
        }

        for (int i = 0; i < list[v].size(); i++) {
            if (!visit[list[v].get(i).next]){
                dfs(list[v].get(i).next, sum+list[v].get(i).val);
                visit[list[v].get(i).next] = true;
            }
        }
    }
}