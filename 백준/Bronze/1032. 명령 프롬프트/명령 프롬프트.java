import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] str;
    static boolean[] right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        String temp = str[0];
        right = new boolean[temp.length()];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) != str[i].charAt(j)){
                    right[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            if (right[i]){
                sb.append('?');
            }
            else sb.append(temp.charAt(i));
        }

        System.out.println(sb);
    }
}