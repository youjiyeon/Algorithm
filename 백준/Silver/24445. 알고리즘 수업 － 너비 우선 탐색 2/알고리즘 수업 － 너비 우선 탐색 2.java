import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, R;
    public static int[] order;
    public static boolean[] visit;
    public static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        order = new int[N+1];
        visit = new boolean[N+1];
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st =  new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
            Collections.reverse(list[i]);
        }

        bfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    private static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        visit[r] = true;
        int cnt = 1;

        while (!q.isEmpty()){
            int cur = q.poll();
            order[cur] = cnt;

            for (int i = 0; i < list[cur].size(); i++) {
                if(!visit[list[cur].get(i)]){
                    q.offer(list[cur].get(i));
                    visit[list[cur].get(i)] = true;
                }
            }
            cnt++;
        }
    }
}