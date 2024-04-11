import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N==0) {
            System.out.println(1);
            System.exit(0);
        }
        
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        if (N==P && val<=arr[N-1]) {
            System.out.println(-1);
        }
        else {
            int rank = 1;
            for (int i = 0; i < N; i++) {
                if (val<arr[i]) rank++;
                else break;
            }

            System.out.println(rank);
        }
    }
}