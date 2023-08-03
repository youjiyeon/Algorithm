import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static String str;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int t = 1;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if ((i/t)>=10){
                t*=10;
                cnt++;
            }
            sum += cnt;
        }
        System.out.println(sum);
    }
}