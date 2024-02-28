import java.io.*;
import java.util.*;

public class Solution {
    public static int H, W, N, M, power, res;
    public static int[] dreamHash;
    public static int[][] teacherHash;
    public static String[] dream, teacher;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            res = 0;

            dream = new String[H];
            for (int i = 0; i < H; i++) {
                dream[i] = br.readLine();
            }
            teacher = new String[N];
            for (int i = 0; i < N; i++) {
                teacher[i] = br.readLine();
            }

            // 해시 값 만들기
            dreamHash = new int[H];
            for (int i = 0; i < H; i++) {
                dreamHash[i] = initHash(dream[i]);
            }

            teacherHash = new int[N][M-W+1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= M - W; j++) {
                    if (j == 0) {
                        teacherHash[i][0] = initHash(teacher[i].substring(0, W));
                    } else {
                        teacherHash[i][j] = (teacherHash[i][j-1] - teacher[i].charAt(j-1) * power) * 33 + teacher[i].charAt(W + j - 1);
                    }
                }
            }

            int dreamHashNum = 0;
            int power = 1;
            for (int i = 0; i < H; i++) {
                dreamHashNum += dreamHash[H-i-1] * power;
                power *= 43;
            }

            for (int i = 0; i <= M-W; i++) {
                int teacherHashNum = 0;
                power = 1;
                for (int j = 0; j <= N-H; j++) {
                    if (j == 0) {
                        for (int k = 0; k < H; k++) {
                            teacherHashNum += teacherHash[H-k-1][i] * power;
                            if (k < H - 1) power *= 43;
                        }
                    }
                    else {
                        teacherHashNum = (teacherHashNum - teacherHash[j-1][i] * power) * 43 + teacherHash[j+H-1][i];
                    }
                    if (teacherHashNum == dreamHashNum) res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    public static int initHash(String str) {
        int ret = 0;
        int hash = 33;
        power = 1;
        for (int i = 0; i < str.length(); i++) {
            ret += str.charAt(W - i - 1) * power;
            if (i < W - 1) power *= hash;
        }

        return ret;
    }
}