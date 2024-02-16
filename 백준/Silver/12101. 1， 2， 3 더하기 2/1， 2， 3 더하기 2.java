import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static String ans = "-1";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            perm(i,i, "");
        }
        System.out.println(ans);
    }

    public static void perm(int cur, int sum, String str){
        if (sum==n){
            k--;
            if (k==0){
                str+=cur;
                ans = str;
                return;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum+i>n) continue;
            perm(i, sum+i, str+cur+'+');
        }
    }
}