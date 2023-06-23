import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_Main {
    public static int cnt, H, W;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 빗물 계산
        rain();
        System.out.println(cnt);
    }

    private static void rain() {
        int max = arr[0];
        for (int i = 0; i < W; i++) {
            int temp = 0;
            int inMax = 0;
            int next = i+1;

            // 자신과 같거나 큰값 확인
            while (true){
                if (next>=W) {
                    break;
                }
                inMax = Math.max(inMax, arr[next]);
                if (max>arr[next]){
                    temp+=(max-arr[next]);
                }
                // 더 크거나 max값이랑 같은 수를 만난다면?
                else {
                    break;
                }
                next++;
            }

            // 있다면?
            if (max<=inMax){
                cnt+=temp;
                i = next-1;
            }
            else {
                i = i-1;
            }
            max = inMax;
        }
    }
}
