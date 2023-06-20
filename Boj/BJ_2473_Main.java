import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2473_Main {
    public static long[] arr, pick;
    public static int m1 = 0, m2 = 0, m3 = 0, N;
    public static long min;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        pick = new long[3];
        min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        // 투 포인터
        for (int i = 0; i < N-2; i++) {
            twoPointer(i);
        }

        Arrays.sort(pick);
        System.out.println(pick[0]+" "+pick[1]+" "+pick[2]);
    }

    private static void twoPointer(int index) {
        int left = index+1;
        int right = arr.length-1;

        while (left<right){
            long sum = arr[left]+arr[right]+arr[index];
            if(min>Math.abs(sum)){
                min = Math.abs(sum);
                pick[0] = arr[left]; pick[1] = arr[right]; pick[2] = arr[index];
            }

            if(sum>=0) right--;
            else left++;
        }

    }
}