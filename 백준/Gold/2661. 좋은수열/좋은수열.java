import java.io.*;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backtracking("");
    }

    private static void backtracking(String str) {
        if (str.length() == N){
            System.out.println(str);
            System.exit(0);
        }
        else {
            for (int i = 1; i <= 3; i++) {
                if (isGood(str + i)) {
                    backtracking(str + i);
                }
            }
        }
    }

    private static boolean isGood(String s) {
        int len = s.length();

        for (int i = 1; i <= len/2; i++) {
            if(s.substring(len-i).
                    equals(s.substring(len -2 * i, len-i))){
                return false;
            }
        }
        return true;
    }
}