import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, K, ans;
    public static int[] arr, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cnt = new int[100001];
        ans = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        twoPoint();
        System.out.println(ans);
    }

    private static void twoPoint() {
        int left = 0;
        int right = 0;

        while (right<N){
            while (right < N && cnt[arr[right]]+1<=K){
                cnt[arr[right]]++;
                right++;
            }
            ans = Math.max(ans, (right-left));
            cnt[arr[left]]--;
            left++;
        }
    }
}
