import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] map = new Integer[n];
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(map, Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, map[i]*(i+1));
        }

        System.out.println(max);
    }
}