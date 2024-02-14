import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int n, m, max = 0, min = 0;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            min += arr[i];
        }

        two();
        System.out.println(max);

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > max) {
                m--;
                sum = arr[i];
                sb.append(cnt).append(" ");
                cnt = 1;
            }
            else cnt++;

            if(m==(n-i))
                break;
        }

        for (int i = 0; i < m; i++) {
            sb.append(cnt).append(" ");
            cnt = 1;
        }
        System.out.println(sb);
    }

    public static void two() {
        int mid = 0;
        while (min >= max) {
            mid = (min+max)/2;

            int cnt = count(mid);
            if (cnt > m) {
                max = mid+1;
            }
            else {
                min = mid-1;
            }
        }
    }

    public static int count(int mid) {
        int sum = 0;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > mid) {
                cnt++;
                sum = arr[i];
            }
        }
        return cnt;
    }
}