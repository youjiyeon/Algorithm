import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class BJ_10025_Main {
    public static int N, K, result;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] += ice;
        }

        // 투 포인터 & 슬라이드
        twoPoint();

        System.out.println(result);
    }

    private static void twoPoint() {
        int sum = 0;
        // 앞부분에서 k범위를 더함
        for (int i = 0; i < 1+2*K && i <= 1000000; i++) {
            sum += arr[i];
        }
        result = sum;
        // 범위를 넓혀가면서 최대값 비교
        for (int i = 1+2*K, j = 0; i <= 1000000; i++, j++) {
            sum -= arr[j];
            sum += arr[i];
            if (sum > result)
                result = sum;
        }
    }
}
