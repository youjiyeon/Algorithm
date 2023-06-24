import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12847_Main {
    public static int N, X;
    public static long max;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        max = 0l;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이드
        slide();
        System.out.println(max);
    }

    private static void slide() {
        long sum = 0;
        for (int i = 0; i < X; i++) {
            sum+=arr[i];
        }
        max = sum;

        for (int i = 0, j = X; j < N; i++, j++) {
            sum-=arr[i];
            sum+=arr[j];
            if(max<sum){
                max = sum;
            }
        }
    }
}
