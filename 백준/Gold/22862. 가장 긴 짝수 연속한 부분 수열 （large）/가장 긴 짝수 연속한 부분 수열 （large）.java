/*
    while문 조건은 s<=n
    s와 e를 처음엔 1로 하고
    짝수가 아닌게 K를 넘어가면 or 끝에 도달하면
    s++, e=s 초기화
 */
import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, max = Integer.MIN_VALUE;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1;
        int e = 1;
        int odd = 0;
        int even = 0;
        while (e<=n){
            if (odd>k){
                // 짝수면
                if (arr[s]%2==0){
                    while (arr[s]%2==0){
                        even--;
                        s++;
                    }
                }
                // 홀수면
                odd--;

                s++;
            }

            // e가 짝수면
            if (arr[e]%2==0){
                even++;
                e++;
            }
            // e가 홀수면
            else { // if (arr[e]%2!=0)
                odd++;
                e++;
            }
            max = Math.max(max, even);

        }
        System.out.println(max);
    }
}