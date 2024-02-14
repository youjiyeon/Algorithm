import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;
        // 앞그룹
        for (int i = 1; i <= n-1; i++) {
            // 뒷그룹
            for (int j = i+1; j <= n; j++) {

                int s = i;
                int e = j;
                // 앞, 뒤 그룹의 구분자
                int mid = 0;
                while (s<=e){
                    mid = (s+e)/2;
                    int front = arr[mid]-arr[i-1];
                    int back = arr[j]-arr[mid];
                    if (min>Math.abs(front-back)){
                        min = Math.abs(front-back);
                        sum = front+back;
                    }
                    else if (min==Math.abs(front-back)) {
                        sum = Math.max(sum, front+back);
                    }
                    // 앞 그룹이 더 크다면
                    if (front>back) e = mid-1;
                    else s = mid+1;
                }
            }
        }
        System.out.println(sum);
    }
}