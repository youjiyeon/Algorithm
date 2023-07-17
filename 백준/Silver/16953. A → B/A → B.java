import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static long B;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        if (A==B)
        {
            System.out.println(0);
        }
        else
            System.out.println(bfs(A));
    }

    private static long bfs(long n) {
        long cnt = 1;
        Queue<Long> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long cur = q.poll();
                if (cur==B){
                    return cnt;
                }
                if (cur*2<=B){
                    q.offer(cur*2);
                }
                if ((cur*10)+1<=B){
                    q.offer((cur*10)+1);
                }
            }
            cnt++;
        }
        return -1;
    }
}