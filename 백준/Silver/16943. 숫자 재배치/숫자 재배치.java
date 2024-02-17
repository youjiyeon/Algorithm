import java.io.*;
import java.util.*;

public class Main {
    public static String A, B, C;
    public static int a,b,c;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        A = stringTokenizer.nextToken();
        B = stringTokenizer.nextToken();
        C = "";

        a = Integer.parseInt(A);
        b = Integer.parseInt(B);
        c = -1;

        v = new boolean[A.length()];

        back();

        System.out.println(c);
    }
    public static void back() {
        if(C.length()==A.length()){
            if(Integer.parseInt(C) < b)
                c = Math.max(c, Integer.parseInt(C));
            return;
        }

        for(int i = 0 ; i < A.length(); i++){
            if((C.isEmpty() && A.charAt(i)=='0') || v[i])   continue;

            v[i] = true;
            C += A.charAt(i);
            back();
            v[i] = false;
            C = C.substring(0, C.length()-1);
        }
    }
}