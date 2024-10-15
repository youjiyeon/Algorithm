import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;  // 배열의 요소 수
    static int snow[];  // 눈의 높이를 저장하는 배열
    static ArrayList<Snowman> snowmans;  // Snowman 객체를 저장하는 ArrayList

    static class Snowman implements Comparable<Snowman> {
        int headSnowIdx;
        int bodySnowIdx;
        int height;

        // Snowman 클래스의 생성자
        public Snowman(int head, int body, int height) {
            this.headSnowIdx = head;
            this.bodySnowIdx = body;
            this.height = height;
        }

        // 높이를 기준으로 Snowman 객체를 정렬하기 위한 compareTo 메서드 재정의
        @Override
        public int compareTo(Snowman o) {
            return this.height - o.height;
        }
    }

    static int min = Integer.MAX_VALUE;  // 최소 높이 차이를 저장하는 변수

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용한 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 눈의 높이를 저장하는 배열 초기화
        snow = new int[N];

        // 눈의 높이를 읽고 배열 'snow'를 채움
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        // Snowman 객체를 저장하는 ArrayList 초기화
        snowmans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                snowmans.add(new Snowman(i, j, snow[i] + snow[j]));
            }
        }

        // Snowman 객체를 높이를 기준으로 정렬
        Collections.sort(snowmans);

        // 연속적인 Snowman 객체 간의 높이 차이를 저장하는 ArrayList 초기화
        for (int i = 0; i < snowmans.size() - 1; i++) {
            Snowman snowman = snowmans.get(i);
            Snowman nextSnowman = snowmans.get(i + 1);
            int snow1 = snowman.bodySnowIdx;
            int snow2 = snowman.headSnowIdx;
            int snow3 = nextSnowman.bodySnowIdx;
            int snow4 = nextSnowman.headSnowIdx;

            // 두 Snowman 객체가 겹치지 않을 때 높이 차이를 계산하여 최소값 갱신
            if (snow1 != snow3 && snow1 != snow4 && snow2 != snow3 && snow2 != snow4) {
                min = Math.min(min, nextSnowman.height - snowman.height);
            }
        }

        // 최소 높이 차이를 출력
        System.out.println(min);
    }
}