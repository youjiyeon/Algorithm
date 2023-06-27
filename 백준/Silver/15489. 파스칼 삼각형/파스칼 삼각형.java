import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[31][31];
        arr[1][1] = 1;

        for (int i = 1; i < 30; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i+1][j] += arr[i][j];
                arr[i+1][j+1] += arr[i][j];
            }
        }

        int sum = 0;
        for (int i = n, cnt = 0; cnt <w; i++, cnt++) {
            for (int j = k; j <= k+cnt; j++) {
               sum+=arr[i][j];
            }
        }
        System.out.println(sum);
    }

}