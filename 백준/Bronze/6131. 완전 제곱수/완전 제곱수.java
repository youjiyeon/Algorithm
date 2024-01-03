import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int a = 1; a <= 500; a++) {
            for (int b = 1; b <= 500; b++) {
                if ((a*a)-(b*b)==n)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}