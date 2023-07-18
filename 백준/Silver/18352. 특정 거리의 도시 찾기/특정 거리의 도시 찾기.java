import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, K, X;
    public static List<Integer>[] list;
    public static boolean[] visit;
    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }

        bfs(X);

        if (result.size()==0){
            System.out.println(-1);
        }
        else {
            Collections.sort(result);
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    private static void bfs(int v) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cnt==K){
                    result.add(cur);
                }
                else if (cnt>K){
                    return;
                }
                for (int j = 0; j < list[cur].size(); j++) {
                    if (!visit[list[cur].get(j)]){
                        q.offer(list[cur].get(j));
                        visit[list[cur].get(j)] = true;
                    }
                }
            }
            cnt++;
        }
    }

}