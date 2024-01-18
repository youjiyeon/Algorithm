import java.io.*;
import java.util.*;

public class Main {
    public static int n, x;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        System.out.println(two());
    }

    public static int two(){
        int cnt = 0;
        Arrays.sort(arr);
        int s = 0;
        int e = n-1;

        while (s<e){
            if (arr[s]+arr[e]==x){
                cnt++;
                s++;
                e--;
            }
            else if(arr[s]+arr[e]>x){
                e--;
            }
            else {
                s++;
            }
        }

        return cnt;
    }
}