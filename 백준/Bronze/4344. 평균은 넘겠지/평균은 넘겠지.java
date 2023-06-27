import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, sum;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            sum = 0;
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }
            int avg = sum/N;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(avg<arr[i]){
                    cnt++;
                }
            }
            float upAvg = (float)cnt/N*100;
            System.out.println(String.format("%.3f",upAvg)+"%");

        }
    }
}