import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 50/a; i++) {
            for (int j = 1; j <= 50/b; j++) {
                for (int k = 1; k <= 50/c; k++) {
                    if ((i*a)+(j*b)+(k*c) == n){
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(0);
    }
}