import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 7-19 1분 10원
        // 19-7 1분 5월

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            String[] time = s[0].split(":");

            // time[0] -> 시, time[1] -> 분
            // s[1] -> 통화 시간

            int call = Integer.parseInt(s[1]);
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            //System.out.println(h+" "+m+" "+call);

            for (int j = 0; j < call; j++) {
                if ((h>=7 && m>=0) && (h<19 && m<=60)) {
                    sum += 10;
                }
                else {
                    sum += 5;
                }

                m++;
                if (m>=60) {
                    m = 0;
                    h++;
                }
                if (h>=24) {
                    h = 0;
                }
            }

            //System.out.println(sum);
        }

        System.out.println(sum);
    }
}