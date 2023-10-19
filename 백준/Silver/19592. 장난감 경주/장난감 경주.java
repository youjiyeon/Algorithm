import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, X, Y;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 참가자 수
            N = Integer.parseInt(st.nextToken());
            // 총 트랙 길이
            X = Integer.parseInt(st.nextToken());
            // 부스터 제한
            Y = Integer.parseInt(st.nextToken());

            // 속도 저장 배열
            // N-1은 나
            int max = Integer.MIN_VALUE;
            int V;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N-1; i++) {
                V = Integer.parseInt(st.nextToken());
                max = Math.max(max, V);
            }

            double min = 1.0*X/max;
            V = Integer.parseInt(st.nextToken());

            if (V>max){
                sb.append(0);
            }
            else if ((1+1.0*(X-Y)/V)>=min) {
                sb.append(-1);
            }
            else {
                // 부스터 값 범위
                int l = 0;
                int r = Y;
                int m = 0;
                while (l <= r) {
                    m = (l + r) / 2;
                    double temp = 1+1.0 * (X - m) / V;
                    if (min <= temp) {
                        l = m + 1;
                    } else
                        r = m - 1;
                }
                sb.append(l);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}