import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 각각의 경주 시간을 구하고
// 3번째의 경우 0~Y까지 이분탐색해서 min이 나올때까지

public class Main {
    public static int V, N, X, Y, max;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N-1; j++) {
                V = Integer.parseInt(st.nextToken());
                max = Math.max(max, V);
            }
            double com = 1.0*X/max;
            V = Integer.parseInt(st.nextToken());

            if (V>max){
                sb.append(0+"\n");
            } else if (1+1.0*((X-Y)/V)>=com) {
                sb.append(-1+"\n");
            }
            else {
                int left = 0;
                int right = Y;
                int mid = 0;
                while (true){
                    if (left>right)
                        break;

                    mid = (left+right)/2;
                    double mt = 1+1.0*(X-mid)/V;
                    if(mt>=com){
                        left = mid+1;
                    }
                    else {
                        right = mid-1;
                    }
                }
                sb.append(left+"\n");
            }
        }
        System.out.println(sb);
    }

}