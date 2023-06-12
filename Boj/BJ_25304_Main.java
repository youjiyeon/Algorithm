import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25304_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            total -= (val*cnt);
        }

        if(total==0){
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}
