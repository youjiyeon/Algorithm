import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] num, lis, lds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        lis = new int[N];
        lds = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            lis[i] = lds[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i]>num[j])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= i; j--) {
                if (num[i]>num[j])
                    lds[i] = Math.max(lds[i], lds[j]+1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, lis[i]+lds[i]);
        }

        System.out.println(max-1);
    }
}
