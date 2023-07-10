import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(two(Integer.parseInt(st.nextToken()))+" ");
        }
        System.out.println(sb);
    }

    public static int two(int v){
        int r = 0;
        int l = N-1;
        int mid;

        while (r<=l){
            mid = (r+l)/2;
            if(arr[mid]==v){
                return 1;
            }
            else if (arr[mid]<v) {
                r = mid+1;
            }
            else if (arr[mid]>v) {
                l = mid-1;
            }
        }
        return 0;
    }
}