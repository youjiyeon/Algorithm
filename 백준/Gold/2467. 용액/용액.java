import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static long[] arr;
    public static int m1 = 0, m2 = 0, N;
    public static long min;
    public static void main(String[] args) throws IOException {
        // 일단 조합
        // 알카리 + 산성
        // 각각 하나씩
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 투 포인터
        twoPointer();
        System.out.println(arr[m1]+" "+arr[m2]);
    }

    private static void twoPointer() {
        int left = 0;
        int right = N - 1;

        while (left<right){
            long sum = arr[left]+arr[right];
            if(min>Math.abs(sum)){
                min = Math.abs(sum);
                m1 = left; m2 = right;
            }

            if(sum>=0) right--;
            else left++;
        }

    }
}