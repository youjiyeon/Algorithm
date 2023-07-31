import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= (2*n)-1; i++) {
            int cnt = 0;
            int bCnt = 0;
            if (i<n){
                cnt = i%n;
                bCnt = n-i;
            }
            if (i==n){
                cnt = n;
                bCnt = 0;
            }
            if (i>n){
                cnt = (2*n)-i;
                bCnt = i-n;
            }

            for (int j = 0; j < cnt; j++) {
                sb.append("*");
            }
            for (int l = 0; l < 2; l++) {
                for (int j = 0; j < bCnt; j++) {
                    sb.append(" ");
                }
            }
            for (int j = 0; j < cnt; j++) {
                sb.append("*");
            }


            sb.append("\n");
        }
        System.out.println(sb);
    }
}