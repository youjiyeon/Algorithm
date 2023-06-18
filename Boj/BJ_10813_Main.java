import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10813_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 바구니 초기화
        int[] bucket = new int[N+1];
        for (int i = 1; i <= N; i++) {
            bucket[i] = i;
        }
        //

        // M번 명령어 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            int temp = bucket[b1];
            bucket[b1] = bucket[b2];
            bucket[b2] = temp;
        }
        //

        // 결과값 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(bucket[i]+" ");
        }
        //

    }
}
