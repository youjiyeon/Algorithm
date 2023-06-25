import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 설명
연속 M개 중 K미만으로
 */
public class BJ_13422_Main {
    public static int N, M, K, cnt;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cnt = 0;

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(N==M){
                long sum = 0l;
                for (int i = 0; i < M; i++) {
                    sum += arr[i];
                }
                if(sum<K) cnt++;
            }
            else
                // 슬라이드
                slide();

            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    private static void slide() {
        long sum = 0l;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }
        if(sum<K) cnt++;

        for (int i = 0, j = M; i < N-1; i++, j++) {
            if(j>=N){
                j = 0;
            }
            sum-=arr[i];
            sum+=arr[j];
            if(sum<K) cnt++;
        }
    }
}
