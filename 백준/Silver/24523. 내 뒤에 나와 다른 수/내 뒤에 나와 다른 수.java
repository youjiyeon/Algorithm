import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] min = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int m = -1;
        for (int i = n-1; i > 0; i--) {
            min[i] = m;
            if (arr[i-1] != arr[i]) m = i;
        }

        min[0] = m;
        for (int i = 0; i < n; i++) {
            sb.append(min[i]==-1 ? -1 : min[i]+1).append(" ");
        }
        System.out.println(sb);
    }
}