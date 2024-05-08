import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        long ans = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(arr);

        // 2개 먼저 뽑기
        for(int i = 0 ; i < N-1 ; i ++){
            for(int j = i+1 ; j < N ; j ++){
                int lower = binarySearchLow(-1*(arr[i] + arr[j]),  j);
                int upper = binarySearchUp(-1*(arr[i] + arr[j]), j);

                ans += upper - lower;
            }
        }

        System.out.print(ans);
    }

    private static int binarySearchUp(int target, int s) {
        s++;
        int e = N;
        int m = 0;

        while(e > s){
            m = (s + e) / 2;

            if(target >= arr[m]){
                s = m+1;
            }
            else e = m;
        }

        return s;
    }

    private static int binarySearchLow(int target, int s) {
        s++;
        int e = N;
        int m = 0;

        while(e > s){
            m = (s + e) / 2;

            if(target > arr[m]){
                s = m+1;
            }
            else e = m;
        }

        return s;
    }
}