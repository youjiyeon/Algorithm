import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_26091_Main {
    public static int N, M;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 투 포인터
        System.out.println(twoPoint());
    }

    private static int twoPoint() {
        int left = 0;
        int right = N-1;
        int cnt = 0;

        while (left<right){
            if(arr[left]+arr[right]>=M){
                cnt++;
                left++;
                right--;
            }
            else left++;
        }
        return cnt;
    }
}
