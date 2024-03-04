import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long n = 0;
        int cnt = 0;

        for (int i = 1; ; i++) {
            if (n > s) {
                break;
            }
            n += i;
            cnt++;
        }
        System.out.println(cnt-1);
    }
}