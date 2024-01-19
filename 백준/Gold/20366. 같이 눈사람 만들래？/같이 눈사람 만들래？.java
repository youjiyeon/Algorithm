import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long min = Long.MAX_VALUE;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                int s = 0;
                int e = n-1;
                while (s<e){
                    if (s==i || s==j){
                        s++;
                        continue;
                    }
                    if (e==i || e==j){
                        e--;
                        continue;
                    }

                    min = Math.min(min, Math.abs((arr[i]+arr[j])-(arr[s]+arr[e])));

                    if (arr[i]+arr[j]<arr[s]+arr[e])
                        e--;
                    if (arr[i]+arr[j]>=arr[s]+arr[e])
                        s++;
                }
            }
        }
        System.out.println(min);
    }
}
