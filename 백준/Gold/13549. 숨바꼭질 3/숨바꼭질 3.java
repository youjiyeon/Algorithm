import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int K;
    public static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new int[100001];
        if (N==K)
        {
            System.out.println(0);
        }
        else
            System.out.println(bfs(N));
    }

    private static long bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {n, 1});
        visit[n] = 1;

        while (!q.isEmpty()){
            int cur = q.peek()[0];
            int curT = q.peek()[1];
            q.poll();
            if(cur+1>=0 && cur+1<=100000){ // 앞으로 한칸
                if(visit[cur+1] == 0 || visit[cur+1] > curT+1){
                    visit[cur+1] = curT+1;
                    q.add(new int[] {cur + 1, curT + 1});
                }
            }

            if(cur-1>=0 && cur-1<=100000){ // 뒤로 한칸
                if(visit[cur-1] == 0 || visit[cur-1] > curT+1) {
                    visit[cur - 1] = curT + 1;
                    q.add(new int[] {cur - 1, curT + 1});
                }
            }

            if(cur*2>=0 && cur*2<=100000){ // 순간이동
                if(visit[cur*2] == 0 || visit[cur*2] > curT) {
                    visit[cur*2] = curT;
                    q.add(new int[] {cur*2, curT});
                }
            }
        }
        return visit[K]-1;
    }
}