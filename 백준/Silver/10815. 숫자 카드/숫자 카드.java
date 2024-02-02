import java.io.*;
import java.util.*;

class Main {
    static int n, target;
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
            target = Integer.parseInt(st.nextToken());
            bw.write(two()+" ");
        }

        bw.flush();
        bw.close();
    }

    private static int two() {
        int s = 0;
        int e = n-1;
        int mid = (s+e)/2;

        while (s<=e){
            mid = (s+e)/2;
            if (arr[mid]==target) {
                return 1;
            }
            // 타겟보다 작다면
            // 앞값 이동
            else if (arr[mid]<target) {
                s = mid+1;
            }
            // 타겟보다 크면
            // 끝값 이동
            else {
                e = mid-1;
            }
        }
        return 0;
    }
}