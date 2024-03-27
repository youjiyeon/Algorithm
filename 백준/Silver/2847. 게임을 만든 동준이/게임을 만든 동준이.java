import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] game = new int[n];

        for (int i = 0; i < n; i++) {
            game[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = n-1; i > 0; i--) {
            if (game[i]<=game[i-1]) {
                cnt+=(game[i-1]-game[i])+1;
                game[i-1] = game[i]-1;
            }
        }

        System.out.println(cnt);
    }
}