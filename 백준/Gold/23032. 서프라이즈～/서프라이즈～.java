import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 1; i <= n-1; i++) {
            for (int j = i+1; j <= n; j++) {
                // 앞 그룹의 합

                int s = i; //????
                int e = j; //????
                int mid = 0;
                while (s<=e){
                    mid = (s+e)/2;
                    int tmp1 = arr[mid]-arr[i-1];
                    int tmp2 = arr[j]-arr[mid];
                    if (min>Math.abs(tmp1-tmp2)){
                        min = Math.abs(tmp1-tmp2);
                        sum = tmp1+tmp2;
                    }
                    else if (min==Math.abs(tmp1-tmp2)) {
                        sum = Math.max(sum,tmp1+tmp2);
                    }
                    if (tmp1>tmp2) {
                        e=mid-1;
                    }
                    else {
                        s=mid+1;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}