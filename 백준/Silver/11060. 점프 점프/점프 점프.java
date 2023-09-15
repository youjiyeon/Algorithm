import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] map;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0] = true;
        int level = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int cur = q.poll();
                if (cur==N-1){
                    return level;
                }

                for (int i = 1; i <= map[cur]; i++) {
                    int next = cur + i;
                    if (next<0 || next>= N) continue;
                    if (!visit[next]){
                        q.offer(next);
                        visit[next] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}