import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] map = new int[1001];
        int[][] p = new int[n][2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            p[i][0] = s;
            p[i][1] = e;

            for (int j = s; j < e; j++) {
                if (map[j]==0){
                    sum++;
                }
                map[j]++;
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = p[i][0]; j < p[i][1]; j++) {
                if (map[j]-1==0){
                    tmp++;
                }
            }
            max = Math.max(max, sum-tmp);
        }
        
        System.out.println(max);
    }
}