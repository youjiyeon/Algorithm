import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BJ_2407_Main {
    public static long[] arr, pick;
    public static int N;
    public static long min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        pick = new long[2];
        min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        // 투 포인터
        twoPointer();

        System.out.println(pick[0]+" "+pick[1]);
    }

    private static void twoPointer() {
        int left = 0;
        int right = N-1;

        while (left<right){
            long sum = arr[left]+arr[right];
            if(min>Math.abs(sum)){
                min = Math.abs(sum);
                pick[0] = arr[left]; pick[1] = arr[right];
            }

            if (sum > 0)
                right--;
            else left++;
        }

    }
}