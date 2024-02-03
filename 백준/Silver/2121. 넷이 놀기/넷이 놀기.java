import java.io.*;
import java.util.*;

// 4개 특징, [(같,b), (a,같), (a,b)]
class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode() {
            int prime = 1_000_000_007;
            prime = prime*31 + x;
            return prime *31 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node)obj;
            return (this.y == n.y && this.x == n.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;

        Set<Node> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Node(x,y));
        }

        for(Node cur:set){
            Node n1 = new Node(cur.x, cur.y+b);
            Node n2 = new Node(cur.x+a, cur.y);
            Node n3 = new Node(cur.x+a, cur.y+b);
            if (set.contains(n1) && set.contains(n2) && set.contains(n3))
                ans++;
        }
        System.out.println(ans);
    }
}