import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int N;
    public static long[] num;
    public static void main(String[] args) throws IOException {
        //StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(num);

        int cnt = 1;
        int maxCnt = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0, j = 1; j < N; i++, j++) {
            if (num[i]==num[j]){
                cnt++;
            }
            else {
                if (maxCnt<cnt){
                    maxCnt = cnt;
                    max = num[i];
                }
                cnt = 1;
            }
        }
        if (cnt>maxCnt) max = num[N-1];

        System.out.println(max);
    }
}
