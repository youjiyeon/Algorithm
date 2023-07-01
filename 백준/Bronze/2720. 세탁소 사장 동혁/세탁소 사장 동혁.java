import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = 25;
        int d = 10;
        int n = 5;
        int p = 1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int val = Integer.parseInt(br.readLine());
            sb.append(val/q+" ");
            val%=q;

            sb.append(val/d+" ");
            val%=d;

            sb.append(val/n+" ");
            val%=n;

            sb.append(val/p+"\n");
        }
        System.out.println(sb);
    }
}
