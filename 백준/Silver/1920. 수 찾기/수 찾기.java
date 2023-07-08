import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());
            sb.append(find(val)+"\n");
        }
        System.out.println(sb);
    }

    public static int find(int val){
        int start = 0;
        int end = N-1;
        int mid;
        while (start<=end){
            mid = (start+end)/2;
            if(arr[mid]==val)
                return 1;
            else if(arr[mid]<val){
                start=mid+1;
            }
            else if(arr[mid]>val){
                end=mid-1;
            }
        }
        return 0;
    }
}