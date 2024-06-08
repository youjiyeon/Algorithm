import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) arr[0]++;
            else if (x >= 0 && y >= 0) arr[1]++;
            else if (x < 0 && y >= 0) arr[2]++;
            else if (x < 0 && y < 0) arr[3]++;
            else if (x >= 0 && y < 0) arr[4]++;
        }

        for (int i = 1; i < 5; i++) {
            sb.append("Q").append(i).append(": ").append(arr[i]).append("\n");
        }
        sb.append("AXIS: ").append(arr[0]);
        System.out.print(sb);
    }
}