import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] result = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i)-'a';
            result[num]++;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(result[i]+" ");
        }
        System.out.println(sb);
    }
}