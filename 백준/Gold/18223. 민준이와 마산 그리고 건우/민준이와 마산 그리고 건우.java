import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int n;
        int l;
        boolean isP;
        public Node(int n,  int l){
            this.n = n;
            this.l = l;
        }
        public Node(int n,  int l, boolean isP){
            this.n = n;
            this.l = l;
            this.isP = isP;
        }
    }
    public static int v, p, end = 987654321;
    public static boolean ans = false;
    public static int[] dist;
    public static Stack<Integer>[] stacks;
    public static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        stacks = new Stack[v+1];
        dist = new int[v+1];
        list = new List[v+1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
            stacks[i] = new Stack<>();
        }
        // 간선
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            // 양방향
            list[t].add(new Node(f, l));
            list[f].add(new Node(t, l));

        }

        d();
    }

    public static void d(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.l-o2.l);
        pq.offer(new Node(1, 0));
        Arrays.fill(dist, 987654321);
        dist[1] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (cur.n==v){
                if (cur.l>end) {
                    break;
                }
                if (cur.isP) {
                    ans = true;
                    break;
                }
                end = cur.l;
            }

            boolean flag = cur.isP;
            if (cur.n==p){
                flag = true;
            }

            for (Node next:list[cur.n]) {
                if (dist[next.n]<next.l+cur.l)
                    continue;
                dist[next.n] = next.l+cur.l;
                pq.offer(new Node(next.n, dist[next.n], flag));
            }
        }

        if (ans){
            System.out.println("SAVE HIM");
        }
        else
            System.out.println("GOOD BYE");
    }
}