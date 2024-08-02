import java.io.*;
import java.util.*;

public class Main {
    static int len;
    static String s;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();
        visit = new boolean[51];

        restore(0, 0, "");
    }

    static void restore(int idx, int n, String ans) {
        if (idx == len) {
            // 1부터 n까지 숫자 중 하나라도 빠지면 Bye
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) return;
            }
            System.out.println(ans.trim());
            System.exit(0);
            return;
        }

        // 문자열 자르기
        String tmp = s.substring(idx, idx+1);

        // 숫자로 변환
        int num = Integer.parseInt(tmp);

        if (!visit[num]) {
            visit[num] = true;

            // num>n 비교
            // n까지 숫자를 확인해야 하기 때문에 저장
            restore(idx+1, Math.max(num, n), ans+" "+tmp);

            visit[num] = false;
        }
        // 두자리 고려
        // idx가 마지막이 아닐때
        if (idx < len-1) {
            tmp = s.substring(idx, idx+2);
            num = Integer.parseInt(tmp);
            if (num<51 && !visit[num]) {
                visit[num] = true;
                restore(idx+2, Math.max(num, n), ans+" "+tmp);
                visit[num] = false;
            }
        }
    }
}