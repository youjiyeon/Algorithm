import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] num;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(down(target)-up(target)+" ");
        }
        System.out.println(sb);
    }

    private static int up(int target) {
        int l = 0;
        int r = N;
        int mid = 0;

        while (l<r){
            mid = (l+r)/2;

            if (num[mid]>=target){
                r = mid;
            }
            else if (num[mid]<target) {
                l = mid+1;
            }
        }

        return l;
    }

    private static int down(int target) {
        int l = 0;
        int r = N;
        int mid = 0;

        while (l<r){
            mid = (l+r)/2;

            if (num[mid]>target){
                r = mid;
            }
            else if (num[mid]<=target) {
                l = mid+1;
            }
        }

        return r;
    }
}
