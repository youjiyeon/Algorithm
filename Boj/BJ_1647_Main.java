import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1647_Main {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static int N, M;
    public static int[] parents;
    public static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, weight));
        }

        Collections.sort(list);
        set();

        int sum = 0;
        int big = 0;
        for (Node n:list) {
            if(union(n.from, n.to)){
                sum += n.weight;
                big = n.weight;

            }
        }

        System.out.println(sum - big);
    }

    public static void set(){
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static boolean union(int from, int to){
        int fromRoot = find(from);
        int toRoot = find(to);

        if(fromRoot==toRoot) return false;
        else {
            parents[fromRoot] = toRoot;
        }
        return  true;
    }

    public static int find(int v){
        if(parents[v] == v) return v;
        else return parents[v] = find(parents[v]);
    }
}
