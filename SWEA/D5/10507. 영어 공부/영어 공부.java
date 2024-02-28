import java.io.*;
import java.util.*;
public class Solution {
    static int[] map;
    static int n, p, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            map = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                map[i] = Integer.parseInt(st.nextToken());

            max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++)
                binarySearch(i);

            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void binarySearch(int cur) {
        int s = cur;
        int e = n-1;
        int mid = 0;
        while(s <= e){
            mid = (s+e)/2;
            int tmp  = map[mid]-map[cur]+1;
            int res = tmp-(mid-cur+1);

            if (res > p) e = mid - 1;
            else {
                max = Math.max(max, tmp+p-res);
                s = mid + 1;
            }
        }
    }
}