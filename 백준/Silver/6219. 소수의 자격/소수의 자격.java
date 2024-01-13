import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        char c = (char)(d+'0');
        int cnt = 0;

        for (int i = a; i <= b; i++) {
            if(isPrime(i)) {
                String str = String.valueOf(i);
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == c) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <=(int)Math.sqrt(i) ; j++) {
            if (i%j==0){
                return false;
            }
        }
        return true;
    }
}