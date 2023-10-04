import java.io.*;
import java.util.*;

public class Main
{
    public static int n;
    public static int[] map;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n+1];
        visit = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start, end));
    }

    private static long bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        long cnt = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int cur = q.poll();
                if (cur==end)
                    return cnt;

                int l = cur - map[cur];
                int r = cur + map[cur];
                while (l>0){
                    if (!visit[l]){
                        q.offer(l);
                        visit[l] = true;
                    }
                    l-=map[cur];
                }

                while (r<=n){
                    if (!visit[r]){
                        q.offer(r);
                        visit[r] = true;
                    }
                    r+=map[cur];
                }
            }
            cnt++;
        }
        return -1;
    }
}