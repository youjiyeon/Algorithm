import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int al, bl, cl, ans = Integer.MAX_VALUE;

        al = Integer.parseInt(st.nextToken());
        bl = Integer.parseInt(st.nextToken());
        cl = Integer.parseInt(st.nextToken());

        int[] a = new int[al];
        int[] b = new int[bl];
        int[] c = new int[cl];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < al; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bl; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cl; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        // 움 세개를 고르고
        // 완탐으로는 이렇게 되는데
        // 이러면 3개의 배열을 다 돌아야함
        // 두개는 돌고 하나만 이분탐색..?

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        for (int i = 0; i < al; i++) {
            int tA = a[i];
            int tB = near(tA, b);
            int tC1 = near(tB, c);
            int tC2 = near(tA, c);;

            int max1 = Math.max(Math.max(tA, tB), tC1);
            int min1 = Math.min(Math.min(tA, tB), tC1);
            int tmp1 = max1-min1;

            int max2 = Math.max(Math.max(tA, tB), tC2);
            int min2 = Math.min(Math.min(tA, tB), tC2);
            int tmp2 = max2-min2;

            ans = Math.min(ans, Math.min(tmp1, tmp2));
            if (ans==0) break;
        }
        System.out.println(ans);
    }

    // 가까운 값 찾기
    static int near(int target, int[] arr){
        int s = 0;
        int e = arr.length-1;
        int mid = (s+e)/2;
        int tmp = arr[mid];
        int nearest = arr[mid];

        while (s<=e){
            mid = (s+e)/2;
            tmp = arr[mid];
            if (tmp==target){
                return tmp;
            }
            // 타겟보다 작다면
            // s를 땡기기
            else if (tmp<target){
                s = mid+1;
            }
            // 타겟보다 크다면
            // e를 땡기기
            else if (tmp>target){
                e = mid-1;
            }

            // 뭐가 더 가까운지 비교
            if (isNear(tmp, nearest, target)){
                nearest = tmp;
            }
        }
        return nearest;
    }

    private static boolean isNear(int tmp, int nearest, int target) {
        // tmp가 nearest보다 target에 가깝다면?
        if (Math.abs(tmp-target)<Math.abs(nearest-target)) return true;
        return false;
    }
}