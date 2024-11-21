import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] cntX = new int[1001];
        int[] cntY = new int[1001];
        int[][] map = new int[3][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cntX[x]++;
            cntY[y]++;
            map[i][0] = x;
            map[i][1] = y;
        }

        if (cntX[map[0][0]] >= 3) {
            System.out.println("WHERE IS MY CHICKEN?");
        }
        else if (cntY[map[0][1]] >= 3) {
            System.out.println("WHERE IS MY CHICKEN?");
        }
        // 기울기가 같은 지 확인
        else {
            double m1 = (double) (map[1][1] - map[0][1])/(map[1][0]-map[0][0]);
            double m2 = (double) (map[2][1] - map[1][1])/(map[2][0]-map[1][0]);
            if (m1 == m2) System.out.println("WHERE IS MY CHICKEN?");
            else System.out.println("WINNER WINNER CHICKEN DINNER!");
            /*Arrays.sort(map, (o1, o2) -> (o1[0] - o2[0]));
            int tmp1 = Math.abs(map[0][0]-map[1][0]);
            int tmp2 = Math.abs(map[1][0]-map[2][0]);
            if (tmp1 != tmp2) System.out.println("WINNER WINNER CHICKEN DINNER!");
            else {
                //Arrays.sort(map, (o1, o2) -> (o1[1] - o2[1]));
                int tmp3 = Math.abs(map[0][1]-map[1][1]);
                int tmp4 = Math.abs(map[1][1]-map[2][1]);

                if (tmp3 != tmp4) System.out.println("WINNER WINNER CHICKEN DINNER!");
                else {
                    System.out.println("WHERE IS MY CHICKEN?");
                }
            }*/
        }
    }
}