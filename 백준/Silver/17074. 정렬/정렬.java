/*
오름차순인데 같은것도 허용이 되는
그렇다면 앞에 나보다 큰게 있는지 없는지 알아야되고
그걸 지웠을때 오름차순이 허용되는지 알아야됨

완전탐색이라면 하나하나빼면서 뒤에를 확인
누적합이면

1 2 3 2
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;

        int idx = 0;
        int type = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i!=0){
                if (arr[i-1]>arr[i]){
                    idx = i-1;
                    type++;
                }
            }
        }

        switch (type){
            case 0:
                System.out.println(n);
                break;
            case 1:
                if (idx==n-2){
                    if (arr[idx-1]<=arr[idx+1])
                        System.out.println(2);
                    else System.out.println(1);
                }
                else if (idx==0) {
                    if (arr[idx]<=arr[idx+2])
                        System.out.println(2);
                    else System.out.println(1);
                }
                else {
                    if (arr[idx-1]<=arr[idx+1])
                        cnt++;
                    if (arr[idx]<=arr[idx+2])
                        cnt++;
                    System.out.println(cnt);
                }
                break;
            default:
                System.out.println(0);
                break;
        }
    }
}