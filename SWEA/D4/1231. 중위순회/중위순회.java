import java.io.*;
import java.util.*;
 
public class Solution {
    public static int n;
    public static String[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t<=10) {
            // 테스트 케이스마다 초기 출력 형식
            sb.append("#").append(t).append(" ");
 
            n = Integer.parseInt(br.readLine());
            arr = new String[n+1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = st.nextToken();
            }
 
            inOrder(1);
            sb.append("\n");
            t++;
        }
        System.out.println(sb);
    }
    public static void inOrder(int idx){
        // 왼쪽이면
        if (idx*2<=n) inOrder(idx*2);
        sb.append(arr[idx]);
        // 오른쪽이면
        if (idx*2+1<=n) inOrder(idx*2+1);
    }
}
