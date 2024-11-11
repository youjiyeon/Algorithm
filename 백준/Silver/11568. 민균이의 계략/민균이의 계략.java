import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, lis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];

        int len = 1;
        for (int i = 1; i < n; i++) {
            if (lis[len-1] < arr[i]) {
                lis[len++] = arr[i];
            }
            else if (lis[len-1] > arr[i]) {
                int idx = binary(0, len-1, arr[i]);
                lis[idx] = arr[i];
            }
        }

        System.out.println(len);
    }

    static int binary(int left, int right, int target) {
        int mid;

        while (left < right) {
            mid = (left+right)/2;

            if (lis[mid] < target) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }

        return right;
    }
}