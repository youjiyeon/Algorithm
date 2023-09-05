import java.io.*;
import java.util.*;

public class Main {

    public static int[] visit;
    public static int[] way = {-1,1,2};
    public static int t = Integer.MAX_VALUE, cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        visit = new int[100001];

        if (start>=target){
            System.out.println(start-target+"\n"+1);
            return;
        }
        bfs(start, target);
        System.out.println(t+"\n"+cnt);
    }

    public static void bfs(int start, int target){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = 1;

        while (!q.isEmpty()){
            int cur = q.poll();
            if (t< visit[cur]){
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i==2){
                    next = cur*way[i];
                }
                else {
                    next = cur+way[i];
                }
                if (next<0 || next>100000) continue;
                if (next == target){
                    t = visit[cur];
                    cnt++;
                }
                if (visit[next] == 0 || visit[next] == visit[cur]+1){
                    q.offer(next);
                    visit[next] = visit[cur]+1;
                }
            }
        }
    }
}