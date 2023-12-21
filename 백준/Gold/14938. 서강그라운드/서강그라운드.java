import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int n;
        int l;

        public Node(int n, int l) {
            this.n = n;
            this.l = l;
        }
    }

    // n: 지역 수, m: 수색범위, r: 길의 수(간선수)
    public static int n, m, r, sum, max = Integer.MIN_VALUE;
    // 각 지역별 아이템 수 저장
    public static int[] item, dist;
    public static List<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        dist = new int[n+1];
        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            // 양방향
            list[to].add(new Node(from, length));
            list[from].add(new Node(to, length));
        }

        for (int i = 1; i <= n; i++) {
            sum = 0;
            sum+=item[i];
            for (int j = 1; j <= n; j++) {
                if (i!=j){
                    if(d(i, j)) {
                        sum += item[j];
                    }
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static boolean d(int s, int e){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)->o1.l-o2.l);
        q.offer(new Node(s, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!q.isEmpty()){
            Node cur = q.poll();
            if (dist[cur.n]< cur.l)
                continue;

            for (Node next: list[cur.n]) {
                if (dist[next.n]>cur.l+next.l){
                    if (cur.l+next.l>m)
                        continue;
                    if (next.n==e){
                        return true;
                    }
                    dist[next.n]=cur.l+next.l;
                    q.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return false;
    }
}