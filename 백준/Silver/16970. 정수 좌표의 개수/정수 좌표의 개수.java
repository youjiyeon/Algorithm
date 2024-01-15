import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= N; k++) {
                    for (int l = 0; l <= M; l++) {
                        if (i==k && l==j) continue;
                        if(gcd(Math.abs(i-k), Math.abs(j-l))+1==K){
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt/2);
    }

    private static int gcd(int a, int b) {
        while (b!=0){
            int tmp = a%b;
            a=b;
            b = tmp;
        }
        return a;
    }
}