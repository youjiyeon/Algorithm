import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 대문자면 소문자로 바꾸기
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                // 소문자면 대문자로 바꾸기
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb);
    }
}