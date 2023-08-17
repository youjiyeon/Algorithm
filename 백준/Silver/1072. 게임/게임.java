import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Y + cnt % X => Z
// 계산을 하고 Z가 바뀌었을 때의 값(cnt) 출력

public class Main {
    public static double X, Y, Z;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Double.parseDouble(st.nextToken());
        Y = Double.parseDouble(st.nextToken());
        Z = Math.floor(100*Y/X);

        cnt = -1;
        if (Z<99){
            int l = 0;
            int r = 1000000000;
            int mid = 0;
            while (l<=r) {
                mid = (l + r) / 2;

                //이분탐색 결과 확률
                double tempZ = Math.floor((100 * (Y + mid)) / (X + mid));

                if (Z >= tempZ)
                {
                    cnt = mid + 1;
                    l = mid + 1;
                }

                else
                    r = mid - 1;
            }
        }
        System.out.println(cnt);
    }
}
