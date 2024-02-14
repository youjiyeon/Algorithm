import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr;
    public static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int m1 = Integer.MAX_VALUE;
            int m2 = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if(i!=j) {
                    int d1 = Math.abs(arr[i][0] - arr[j][0])+Math.abs(arr[i][1] - arr[j][1])+Math.abs(arr[i][2] - arr[j][2]);
                    if(m1>d1) {
                        m2 = m1;
                        m1 = d1;
                    }
                    else if(m2>d1) {
                        m2 = d1;
                    }
                }
            }
            result = Math.min(m1+m2, result);
        }
        System.out.println(result);
    }
}