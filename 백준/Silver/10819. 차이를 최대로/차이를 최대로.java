import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, max = Integer.MIN_VALUE;
    public static int[] num, pick;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        pick = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        per(0);
        System.out.println(max);
    }

    private static void per(int cnt) {
        if (cnt==N){
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if(i+1<N){
                    sum += Math.abs(pick[i]-pick[i+1]);
                }
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]){
                pick[cnt] = num[i];
                visit[i] = true;
                per(cnt+1);
                visit[i] = false;
            }
        }
    }
}