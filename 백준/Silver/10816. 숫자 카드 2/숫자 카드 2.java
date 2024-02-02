import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            bw.write((up(target)-low(target))+" ");
        }

        bw.flush();
        bw.close();
    }

    // 맨 뒤의 위치(오른쪽 끝)
    private static int up(int target) {
        int s = 0;
        int e = n;
        int mid = 0;

        while (s<e){
            mid = (s+e)/2;
            if (arr[mid]>target) {
                e = mid;
            }
            else {
                s = mid+1;
            }
        }
        return e;
    }

    // 맨 앞의 위치(왼쪽 끝)
    private static int low(int target) {
        int s = 0;
        int e = n;
        int mid = 0;

        while (s<e){
            mid = (s+e)/2;
            if (arr[mid]>=target) {
                e = mid;
            }
            else {
                s = mid+1;
            }
        }
        return s;
    }
}