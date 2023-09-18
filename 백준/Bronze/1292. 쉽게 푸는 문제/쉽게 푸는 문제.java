import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int[] num = new int[1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0, cnt = 1; i <= b; cnt++) {
            int j = 0;
            for (j = 0; j < cnt; j++) {
                if(i+j<=b)
                    num[i+j] = cnt;
            }
            i += j;
        }

        for (int i = a-1; i < b; i++) {
            sum+=num[i];
        }
        System.out.println(sum);
    }
}