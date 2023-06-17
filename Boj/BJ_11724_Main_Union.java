import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11724_Main {
    public static int N;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        List<Integer>[] list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        set();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        for (int i = 1; i <= N ; i++) {
            hs.add(find(parent[i]));
        }
        System.out.println(hs.size());
    }
    public static void set(){
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    public static void union(int from, int to){
        int fromRoot = find(from);
        int toRoot = find(to);
        if(fromRoot!=toRoot)
        {
            parent[toRoot] = fromRoot;
        }
    }

    public static int find(int v){
        if(parent[v]==v) return v;
        else return parent[v] = find(parent[v]);
    }
}
