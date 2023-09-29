import java.io.*;
import java.util.*;

public class Main
{
    public static int n;
    public static int[] map, way = {-1,1};
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());
        System.out.println(bfs(start-1));
        
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        int cnt = 1;

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int w:way) {
                int next = (w*map[cur])+cur;
                if (next<0 || next>=n || visit[next])
                    continue;

                q.offer(next);
                visit[next] = true;
                cnt++;
            }
        }
        return cnt;
    }


}