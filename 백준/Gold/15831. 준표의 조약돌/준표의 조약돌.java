import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int s = 0;
        int e = 0;
        int cntW = 0;
        int cntB = 0;
        int max = 0;
        while (e<N){
            if (cntB>B){
                if (str.charAt(s)=='B'){
                    cntB--;
                    s++;
                }
                else {
                    cntW--;
                    s++;
                }
            }
            else {
                if (str.charAt(e) == 'W') {
                    cntW++;
                    e++;
                } else if (str.charAt(e) == 'B') {
                    cntB++;
                    e++;
                }

            }

            if (cntB<=B && cntW >= W) {
                max = Math.max(max, e - s);
            }
        }
        System.out.println(max);
    }
}