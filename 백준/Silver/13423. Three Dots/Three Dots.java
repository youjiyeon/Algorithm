import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int cnt = 0;
            // 뒤에 2개의 숫자가 와야되니깐
            for (int i = 0; i < n-2; i++) {
                int e = i+2;
                for (int j = i+1; j < n-1; j++) {
                    int tmp = arr[j]-arr[i];

                    while (e<n && arr[e]-arr[j]<tmp) e++;

                    if (e==n) break;
                    if (arr[e]-arr[j] == tmp) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}