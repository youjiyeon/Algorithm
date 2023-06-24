import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14465_Main {
    public static int N, X, max, cnt;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        max = 0; cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이드
        slide();
        if (max==0) {
            System.out.println("SAD");
            System.exit(0);
        }
        System.out.println(max+"\n"+cnt);
    }

    private static void slide() {
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum+=arr[i];
        }
        max = sum;
        //System.out.println(max);
        if(max!=0) cnt = 1;

        for (int i = 0, j = X; j < N; i++, j++) {
            sum-=arr[i];
            sum+=arr[j];
            //System.out.println(sum);
            if(max<sum){
                max = sum;
                cnt = 1;
            }
            else if (max==sum){
                cnt++;
            }
        }
    }
}
