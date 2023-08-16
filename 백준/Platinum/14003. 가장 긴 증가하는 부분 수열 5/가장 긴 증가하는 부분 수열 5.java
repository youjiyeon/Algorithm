import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] num, dp, idx;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new int[N+1];
        idx = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        dp[0] = Integer.MIN_VALUE;
        int i = 0;
        while (i<N){
            if (dp[j]<num[i]){
                dp[j+1] = num[i];
                idx[i] = j+1;
                j++;
            }
            else {
                int index = bs(0,j,num[i]);
                dp[index] = num[i];
                idx[i] = index;
            }
            i++;
        }
        sb.append(j+"\n");

        int len = j;
        /*for (int k = 0; k < N; k++) {
            System.out.print(idx[k]+" ");
        }
        System.out.println();
        for (int k = 0; k < N; k++) {
            System.out.print(dp[k]+" ");
        }
        System.out.println();*/
        Stack<Integer> stack = new Stack<>();
        for (int k = N-1; k >= 0; k--) {
            if (len==0)
                break;
            if (len==idx[k]){
                stack.push(num[k]);
                len--;
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static int bs(int l, int r, int target) {
        int mid = 0;
        while (l<r){
            mid = (l+r)/2;
            if (dp[mid]<target){
                l = mid+1;
            }
            else r = mid;
        }
        return l;
    }
}
