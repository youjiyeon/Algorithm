import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_Main {
    public static int N, K, max;
    public static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        val = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        twoPoint();
        System.out.println(max);
    }

    private static void twoPoint() {


        for (int i = 0; i <= N-K; i++) {
            int sum = 0;

            for (int j = i; j < i+K; j++) {
                sum+=val[j];
            }
            max = Math.max(max, sum);
        }

    }
}
