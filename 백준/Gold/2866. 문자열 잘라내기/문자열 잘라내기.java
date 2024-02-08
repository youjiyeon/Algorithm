import java.io.*;
import java.util.*;

public class Main {
    static int r, c, min = Integer.MAX_VALUE;
    static char[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int s = 0;
        int e = r-1;
        int mid = 0;

        while (s<=e){
            mid = (s+e)/2;
            // 제거 가능하다면
            // 더 큰 s찾기!
            if (isRevome(mid)){
                s = mid+1;
            }
            // 아니면 범위줄이기
            else {
                e = mid-1;
            }
        }

        System.out.println(s);
    }
    static boolean isRevome(int mid){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < c; i++) {
            String str = "";
            for (int j = mid+1; j < r; j++) {
                str+=arr[j][i];
            }
            if (set.contains(str)){
                return false;
            }
            else set.add(str);
        }
        return true;
    }
}