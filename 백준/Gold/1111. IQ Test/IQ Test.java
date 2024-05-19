import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 나올 경우의 수가 많다
        if (n == 1 || (n == 2 && arr[0] != arr[1])) {
            sb.append("A");
        }
        else if (n == 2) {
            sb.append(arr[0]);
        }
        else {
            int a, b;
            if (arr[1] == arr[0]) {
                a = 1;
                b = 0;
            }
            else {
                a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                b = arr[1] - (arr[0] * a);
            }

            int i = 1;
            for (; i < n; i++) {
                if (arr[i] != (arr[i-1] * a + b)) break;
            }

            if (i == n) {
                sb.append((arr[n - 1] * a + b));
            }
            else sb.append("B");
        }

        System.out.println(sb);
    }
}