import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[45];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < 45; i++) {
            arr[i] = i*(i+1)/2;
        }

        for (int T = 0; T < N; T++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(eureka(t)).append("\n");
        }

        System.out.print(sb);
    }

    static int eureka(int target) {
        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == target) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}