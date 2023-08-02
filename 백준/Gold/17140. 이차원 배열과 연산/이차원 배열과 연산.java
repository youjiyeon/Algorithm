import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int number;
        int count;

        Pair(int n, int c) {
            this.number = n;
            this.count = c;
        }

        // count 가 작은 게 앞으로, 같으면 number 가 작은게 앞으로
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                return -1;
            }
        }
    }
    public static int tx, ty, tv, R = 3, C = 3;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(st.nextToken());
        ty = Integer.parseInt(st.nextToken());
        tv = Integer.parseInt(st.nextToken());

        arr = new int[101][101];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static int solution() {

        for (int i = 0; i <= 100; i++) {
            if (arr[tx][ty] == tv){
                return i;
            }
            operating();
        }
        return -1;
    }

    private static void operating() {
        // R연산
        if (R>=C){
            for (int i = 1; i <= R; i++) {
                R(i);
            }
        }

        // C연산
        else {
            for (int i = 1; i <= C; i++) {
                C(i);
            }
        }
    }

    private static void R(int r) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 1; j <= C; j++) {
            if (arr[r][j] == 0) continue;
            map.compute(arr[r][j], (num, count) -> count == null ? 1 : count+1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            arr[r][i++] = p.number;
            arr[r][i++] = p.count;
        }

        C = Math.max(C, i);

        while (i<=99){
            arr[r][i++] = 0;
            arr[r][i++] = 0;
        }
    }

    private static void C(int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 1; j <= R; j++) {
            if (arr[j][c] == 0) continue;
            map.compute(arr[j][c], (num, count) -> count == null ? 1 : count+1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            arr[i++][c] = p.number;
            arr[i++][c] = p.count;
        }

        R = Math.max(R, i);

        while (i<=99){
            arr[i++][c] = 0;
            arr[i++][c] = 0;
        }
    }
}