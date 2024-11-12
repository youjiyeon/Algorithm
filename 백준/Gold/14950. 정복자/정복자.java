import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int wight;

        public Node(int from, int to, int wight) {
            this.from = from;
            this.to = to;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node n){
            return this.wight - n.wight;
        }
    }

    public static int N, M, t;
    public static int[] parents;
    public static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();
        parents = new int[N+1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, wight));
        }
        Collections.sort(list);
        set();

        int sum = 0;
        int cnt = 0;

        for (Node n : list) {
            if(union(n.from, n.to)){
                sum += n.wight+(cnt*t);
                cnt++;
                if(cnt == M-1) break;
            }
        }
        System.out.println(sum);
    }

    public static void set(){
        for (int i = 1; i <= N; i++) {
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