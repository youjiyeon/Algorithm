import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr, lis, lds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];
        lds = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = lds[i] = 1;
        }

        // 최장 증가 수열
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }

        // 최장 감소 수열
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= i; j--) {
                if (arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j]+1);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, lis[i]+lds[i]);
        }

        System.out.println(ans-1);
    }
}