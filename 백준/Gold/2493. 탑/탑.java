import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static class Node{
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            q.offer(new Node(val, i));
        }

        while (!q.isEmpty()){
            if(s.isEmpty()){
                sb.append(0+" ");
                s.push(q.poll());
            } else if (s.peek().val>q.peek().val) {
                sb.append(s.peek().idx+" ");
                s.push(q.poll());
            } else {
                s.pop();
            }
        }

        System.out.println(sb);
    }
}