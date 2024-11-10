import java.io.*;
import java.util.*;

public class Main {
    static final int start = 1, end = 100;
    static int ans = Integer.MAX_VALUE;
    static boolean[] v = new boolean[end+1];
    static Map<Integer, Integer> ladder, snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ladder = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        snake = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == end) {
                    ans = cnt;
                    return;
                }

                for (int i = 1; i <= 6; i++) {
                    int next = cur+i;

                    if (next > end) continue; // 100 넘어가면 패쓰
                    if (v[next]) continue; // 방문했다면 패쓰

                    // 사다리에 존재한다면 사다리 이동 시 변경되는 수로 변경
                    if (ladder.containsKey(next)) {
                        next = ladder.get(next);
                    }
                    // 뱀에 존재한다면 사다리 이동 시 변경되는 수로 변경
                    else if (snake.containsKey(next)) {
                        next = snake.get(next);
                    }

                    q.offer(next);
                    v[next] = true;
                }
            }
            cnt++;
        }
    }
}