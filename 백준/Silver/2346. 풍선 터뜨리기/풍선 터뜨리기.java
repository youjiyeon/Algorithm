import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int idx;
        int val;
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Node> q = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.offer(new Node(i+1, Integer.parseInt(st.nextToken())));
        }


        Node first = q.poll();
        sb.append(first.idx).append(" ");
        int cnt = first.val;

        while (!q.isEmpty()) {
            if (cnt>0) {
                while (--cnt > 0) {
                    q.offer(q.poll());
                }
                Node tmp = q.poll();
                cnt = tmp.val;
                sb.append(tmp.idx).append(" ");
            }
            else {
                while (cnt++ < -1) {
                    q.offerFirst(q.pollLast());
                }
                Node tmp = q.pollLast();
                cnt = tmp.val;
                sb.append(tmp.idx).append(" ");
            }
        }
        System.out.print(sb);
    }
}