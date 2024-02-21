import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static class Node{
        int left;
        int cnt;
        public Node(int left, int cnt){
            this.left = left;
            this.cnt = cnt;
        }
    }
    public static int n, k, min;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            min = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i]);
            }
            k = Integer.parseInt(br.readLine());

            PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.cnt-o2.cnt);
            q.add(new Node(k, 0));

            int cnt = k;
            while (!q.isEmpty()){
                Node cur = q.poll();
                if (cur.left==0){
                    cnt = cur.cnt;
                    break;
                }

                q.add(new Node(0, cur.cnt+cur.left));
                for (int i = 0; i < n; i++) {
                    q.add(new Node(cur.left/arr[i], cur.cnt+cur.left%arr[i]));
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}