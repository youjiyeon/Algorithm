import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003_Main {
    public static int N, M, cnt;
    public static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        twoPoint();
        System.out.println(cnt);
    }

    private static void twoPoint() {
        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            right = i;
            while (true){
                if(right>=N) break;
                sum += num[right];
                if(sum==M){
                    //System.out.println(i+" "+right);
                    cnt++;
                    break;
                }
                right++;
            }
        }
    }
}
