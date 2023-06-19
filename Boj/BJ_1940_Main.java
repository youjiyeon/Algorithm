import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1940_Main {
    public static int N, M, cnt;
    public static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cnt = 0;

        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        twoPoint();
        System.out.println(cnt);

    }

    private static void twoPoint() {

        int left = 0;
        int right = left+1;

        while (true){
            if(right>=N){
                left++;
                right = left+1;
                if(left>=N-1){
                    break;
                }
            }
            if(num[left]+num[right]==M){
                cnt++;
            }
            right++;
        }
    }
}
