import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[] num;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[2000001];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            num[val+1000000]++;
        }

        int cnt = 0;
        for (int i = 0; i <= 2000000; i++) {
            if (cnt==N)
                break;
            while (num[i]--!=0){
                sb.append(i-1000000).append("\n");
                cnt++;
            }
        }

        System.out.println(sb);
    }
}
