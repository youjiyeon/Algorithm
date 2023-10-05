import java.io.*;
import java.util.*;

public class Main
{
    public static int n;
    public static int[] num;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);
        for (int i: num) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}