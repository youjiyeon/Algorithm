import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2018_Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int idx = i;
            while (true){
                // N이 나온다면? cnt++
                if (sum==N){
                    cnt++;
                    break;
                }
                // 경계 체크
                if (idx>N || sum>N) break;
                sum+=idx;
                idx++;
            }
        }
        System.out.println(cnt);
    }
}
