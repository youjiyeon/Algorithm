import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2*N - 1; i++) {
            if (i<N){
                for (int j = 0; j < N-i; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < i; j++) {
                    sb.append("*");
                }
            }

            if (i==N){
                for (int j = 0; j < i-N; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < N; j++) {
                    sb.append("*");
                }
            }

            if (i>N){
                for (int j = 0; j < i-N; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < N-(i-N); j++) {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}