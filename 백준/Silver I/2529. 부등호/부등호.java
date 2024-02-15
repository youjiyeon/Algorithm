import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    public static int[] pick;
    public static String[] str;
    public static boolean[] v;
    public static String mi, ma;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n+1;

        str = new String[n];
        pick = new int[m];
        v = new boolean[10];

        str = br.readLine().split(" ");

        perm(0);
        System.out.println(ma);
        System.out.println(mi);
    }

    public static void perm(int cnt){
        if (cnt==m){
            long tmp = 0;
            String s = "";
            for (int i:pick) {
                tmp=(tmp*10)+i;
                s += i;
            }

            if (min>tmp){
                min = tmp;
                mi = s;
            }
            if (max<tmp){
                max = tmp;
                ma = s;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (cnt!=0){
                switch (str[cnt-1].charAt(0)){
                    // 앞보다 커야됨
                    case '<':
                        if (pick[cnt-1]>=i) continue;
                        break;
                    // 앞보다 작아야됨
                    case '>':
                        if (pick[cnt-1]<=i) continue;
                        break;
                }
            }
            if (!v[i]) {
                v[i] = true;
                pick[cnt] = i;
                perm(cnt + 1);
                v[i] = false;
            }
        }
    }
}