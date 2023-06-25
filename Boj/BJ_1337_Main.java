import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_1337_Main {
    public static int N, min = Integer.MAX_VALUE;
    public static int[] cnt;
    public static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[N];
        list = new ArrayList<>();

        // 해당 숫자있는지 유무 저장
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            list.add(val);
        }

        Collections.sort(list);
        // 추가되어야할 원소 최소 구하기
        // 슬라이드
        slide();
        System.out.println(min);
    }

    private static void slide() {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 5; j++) {
                if(!list.contains(list.get(i)+j)){
                    cnt[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            min = Math.min(min, cnt[i]);
        }
    }
}
