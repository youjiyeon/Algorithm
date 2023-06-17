import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1197_Main {

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;

        public Node(int from, int to, int wight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    public static int V, E;
    public static int[] parents;
    public static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();
        parents = new int[V+1];


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, weight));
        }
        Collections.sort(list);
        set();

        int sum = 0;
        int cnt = 0;

        for (Node n: list) {
            if(union(n.from, n.to)){
                sum += n.weight;
                cnt++;
                if(cnt == E-1) break;
            }
        }
        System.out.println(sum);
    }

    public static void set(){
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    public static boolean union(int from, int to){
        int fromRoot = find(from);
        int toRoot = find(to);
        if (fromRoot == toRoot) return false;
        else{
            parents[fromRoot] = toRoot;
        }

        return true;
    }

    public static int find(int v){
        if(parents[v] == v) return v;
        else return parents[v]=find(parents[v]);
    }
}
