import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, pick;
    public static int result, N, M;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MIN_VALUE;
        arr = new int[N];
        pick = new int[3];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(0, 0);
        System.out.println(result);
    }

    private static void combi(int cnt, int sum) {
        if(sum>M)
            return;

        if(cnt == 3){
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                pick[cnt] = arr[i];
                visit[i] = true;
                combi(cnt+1,sum+arr[i]);
                visit[i] = false;
            }
        }

    }
}