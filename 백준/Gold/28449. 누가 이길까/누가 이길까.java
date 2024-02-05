// 같은지, 작은지, 큰지
// 제일
// 2 1 0
// 2 1 0
// 1 1 1
// 2 1 0


import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long small = 0, big = 0, same = 0;
    static int[] hi, arc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hi = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }
        arc = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arc[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arc);

        for (int i = 0; i < N; i++) {
            // upper?
            int l = lower(hi[i]);
            int u = upper(hi[i]);
            if (l==u){
                big+=l;
                small+=M-u;
            }
            else {
                big += l;
                same += (u - l);
                small += M - u;
            }
        }
        System.out.println(big+" "+small+" "+same);
    }

    private static int lower(int target) {
        int l = 0;
        int r = M;
        int mid = (l+r)/2;
        int tmp = arc[mid];
        long s = 0;
        while (l<r){
            mid = (l+r)/2;
            tmp = arc[mid];
            if (tmp>=target){
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
    private static int upper(int target) {
        int l = 0;
        int r = M;
        int mid = (l+r)/2;
        int tmp = arc[mid];
        long s = 0;
        while (l<r){
            mid = (l+r)/2;
            tmp = arc[mid];
            if (tmp>target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}