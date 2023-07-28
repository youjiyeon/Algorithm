import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int blank = 0;
        int star = N-1;
        for (int i = 1; i < 2*N; i++) {
            if (i/N==0){
                for (int j = 0; j < blank; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < star; j++) {
                    sb.append("*");
                }
                sb.append("*");
                for (int j = 0; j < star; j++) {
                    sb.append("*");
                }
                blank++;
                star--;
            }
            if (i==N){
                for (int j = 0; j < blank; j++) {
                    sb.append(" ");
                }
                sb.append("*");
                blank--;
                star++;
                sb.append("\n");
                continue;
            }
            if (i/N>=1){
                for (int j = 0; j < blank; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < star; j++) {
                    sb.append("*");
                }
                sb.append("*");
                for (int j = 0; j < star; j++) {
                    sb.append("*");
                }
                blank--;
                star++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}