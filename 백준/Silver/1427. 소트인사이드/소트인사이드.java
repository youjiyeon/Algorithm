import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        arr = str.split("");
        Arrays.sort(arr);
        for (int i = str.length()-1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}