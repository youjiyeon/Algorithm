// 1 2 4 8 9
//

import java.io.*;
import java.util.*;

public class Main {
    static int n, x1, x2, ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = n-1;
        int tmp = 0;
        while (s<e){
            tmp = arr[s]+arr[e];
            if (Math.abs(tmp)<ans){
                ans=Math.abs(tmp);
                x1 = arr[s];
                x2 = arr[e];
            }
            if (tmp>=0) e--;
            else s++;
        }
        System.out.println(x1+" "+x2);
    }
}

