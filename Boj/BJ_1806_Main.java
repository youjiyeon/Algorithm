import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_Main {
    public static int N, S, min;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int sum = arr[i];
            int j = i+1;
            while (true){
                if(j>=N || sum>=S || cnt>=min){
                    break;
                }
                sum += arr[j];
                cnt++;
                j++;
            }
            if(sum>=S) {
                min = Math.min(min, cnt);
            }
        }

        if(min==Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }
}
