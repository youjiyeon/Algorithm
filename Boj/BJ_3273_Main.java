import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_3273_Main {
    public static int N;
    public static long X;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        X = Long.parseLong(br.readLine());

        Collections.sort(list);

        // 투 포인터
        System.out.println(twoPoint());
    }

    private static int twoPoint() {
        int left = 0;
        int right = N-1;
        long sum = 0;
        int cnt = 0;

        while (left<right){
            sum = list.get(left) + list.get(right);
            if (sum == X){
                cnt++;
            }

            if (sum<X){
                left++;
            }
            else right--;
        }
        return cnt;
    }
}
