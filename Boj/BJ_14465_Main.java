import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14465_Main {
    public static int N, K, B, min;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        min = 0;

        for (int i = 0; i < B; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        // 슬라이드
        slide();
        System.out.println(min);
    }

    private static void slide() {
        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum+=arr[i];
        }
        min = sum;

        for (int i = 1, j = K+1; j <= N; i++, j++) {
            if(arr[i]!=0) sum-=arr[i];
            if(arr[j]!=0) sum+=arr[j];
            if(min>sum){
                min = sum;
            }
        }
    }
}
