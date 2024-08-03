import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        // 소문자 + 대문자
        int[] wCnt = new int[52];
        int[] sCnt = new int[52];
        int cnt = 0;
        
        String W = br.readLine();
        String S = br.readLine();
        for (char c : W.toCharArray()) {
            if ('a'<=c && c<='z') {wCnt[c-'a']++;}
            else wCnt[c-'A'+26]++;
        }

        int start = 0;
        int len = 0;
        for (int i = 0; i < s; i++) {
            char c = S.charAt(i);
            if ('a'<=c && c<='z') {sCnt[c-'a']++;}
            else sCnt[c-'A'+26]++;
            len++;

            if (len == g) {
                if (Arrays.equals(wCnt, sCnt)) {
                    cnt++;
                }
                char sc = S.charAt(start);
                if ('a'<=sc && sc<='z') {sCnt[sc-'a']--;}
                else sCnt[sc-'A'+26]--;
                start++;
                len--;
            }
        }

        System.out.println(cnt);
    }
}