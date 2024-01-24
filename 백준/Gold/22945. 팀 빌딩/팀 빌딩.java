import java.io.*;
import java.util.*;

public class Main {
    public static int n, max = Integer.MIN_VALUE;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = n-1;
        int tmp = 0;
        while (s<e){
            tmp = (e-s-1)*Math.min(arr[s],arr[e]);
            if (max<tmp){
                max = tmp;
            }
            if (arr[s]<arr[e]){
                s++;
            }
            else e--;
        }
        System.out.println(max);
    }
}