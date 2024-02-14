import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
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
            //한점에서 이어지는 가장 짧은 간선 2개를 찾아
            int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if(i!=j) {
                    int d1 = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])
                            + Math.abs(arr[i][2] - arr[j][2]);

                    if(min1>d1) {
                        min2 = min1;
                        min1 = d1;
                    }else if(min2>d1) {
                        min2 = d1;
                    }
                }
            }
            result = Math.min(min1+min2, result);
        }
        System.out.println(result);
    }
}