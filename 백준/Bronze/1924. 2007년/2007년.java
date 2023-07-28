import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public static int[] mons = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mon = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int temp = 0;
        for (int i = 1; i < mon; i++) {
            temp+=mons[i];
        }
        temp+=day;

        System.out.println(week[temp%7]);
    }
}