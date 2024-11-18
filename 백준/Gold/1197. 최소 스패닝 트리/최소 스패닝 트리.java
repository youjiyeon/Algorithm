import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int[] parents;
    static class Node implements Comparable<Node> {
        int from; int to; int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, cost));
        }

        set();
        Collections.sort(list);

        int sum = 0;
        int cnt = 0;
        for (Node n : list) {
            if (union(n.from, n.to)) {
                sum += n.cost;
                cnt++;

                if (cnt == E-1) break;
            }
        }

        System.out.println(sum);
    }

    static void set() {
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
    static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);

        if (fromRoot==toRoot) return false;
        else {
            parents[toRoot] = fromRoot;
            return true;
        }
    }

    static int find(int v) {
        if (parents[v] == v) return v;
        else return parents[v] = find(parents[v]);
    }

}