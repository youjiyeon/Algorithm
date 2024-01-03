import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        arr[3] = Integer.parseInt(st.nextToken());
        arr[4] = Integer.parseInt(st.nextToken());

        int max = arr[0]*arr[1]*arr[2]*arr[3]*arr[4];
        Arrays.sort(arr);
        for (int i = arr[0]; i <= 1000000; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (i%arr[j]==0) {
                    cnt++;
                }
                if (cnt>=3){
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }

        System.out.println(0);
    }
}