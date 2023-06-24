import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891_Main {
    public static int P, S, cnt;
    public static String str;
    public static int[] ACGT = new int[4], acgt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        // 비밀번호 만들기
        makePwd();
        System.out.println(cnt);
    }

    private static void makePwd() {
        // 슬라이드하면서 조건 충족하면 cnt++
        acgt = new int[4];
        cnt = 0;
        for (int i = 0; i < P; i++) {
            switch (str.charAt(i)){
                case 'A':
                    acgt[0]++;
                    break;
                case 'C':
                    acgt[1]++;
                    break;
                case 'G':
                    acgt[2]++;
                    break;
                case 'T':
                    acgt[3]++;
                    break;
            }
        }
        if(isRight())
            cnt++;

        for (int i = 0, j = P; j < S; i++, j++) {
            switch (str.charAt(i)){
                case 'A':
                    acgt[0]--;
                    break;
                case 'C':
                    acgt[1]--;
                    break;
                case 'G':
                    acgt[2]--;
                    break;
                case 'T':
                    acgt[3]--;
                    break;
            }
            switch (str.charAt(j)){
                case 'A':
                    acgt[0]++;
                    break;
                case 'C':
                    acgt[1]++;
                    break;
                case 'G':
                    acgt[2]++;
                    break;
                case 'T':
                    acgt[3]++;
                    break;
            }
            if(isRight())
                cnt++;
        }
    }

    private static boolean isRight() {
        for (int i = 0; i < 4; i++) {
            if(acgt[i]<ACGT[i])
                return false;
        }
        return true;
    }
}
