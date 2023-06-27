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
        int[][] arr = new int[31][31];
        arr[1][1] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
        System.out.println(arr[n][k]);
    }

}