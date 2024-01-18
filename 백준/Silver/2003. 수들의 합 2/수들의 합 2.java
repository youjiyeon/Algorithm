import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(two());
    }

    public static int two(){
        int cnt = 0;
        int s = 0;
        int e = 0;
        int sum = arr[0];

        while (e<n){
            if (sum==m){
                cnt++;
                sum -= arr[s];
                s++;
                e++;
                sum += arr[e];
            }
            else if(sum>m){
                sum -= arr[s];
                s++;
            }
            else {
                e++;
                sum += arr[e];
            }
        }

        return cnt;
    }
}