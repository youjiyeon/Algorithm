import java.io.*;
import java.util.*;

public class Main {
    public static int t, n;
    public static int[] candy;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        candy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            t -= candy[i];
        }

        System.out.println(t<=0? "Padaeng_i Happy" : "Padaeng_i Cry");
    }
}