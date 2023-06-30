import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[j][k] += val;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                System.out.print(map[j][k]+" ");
            }
            System.out.println();
        }
    }
}