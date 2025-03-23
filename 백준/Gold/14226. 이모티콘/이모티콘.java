import java.io.*;
import java.util.*;

public class Main {
    static int S;
    static class Node{
        int desk;
        int clip;
        public Node(int desk, int clip) {
            this.desk = desk;
            this.clip = clip;
        }
    }
    static boolean[][] v = new boolean[1001][1001];
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        bfs();
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(1, 0));
        v[1][0] = true;
        int time = 0;

        T: while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();

                if (cur.desk == S) {
                    System.out.println(time);
                    return;
                }

                // 3개의 연산
                // 1. 복사
                q.offer(new Node(cur.desk, cur.desk));

                // 2. 붙여넣기
                if (cur.clip != 0 && cur.desk+cur.clip <= S && !v[cur.desk+cur.clip][cur.clip]) {
                    q.offer(new Node(cur.desk+cur.clip, cur.clip));
                    v[cur.desk+cur.clip][cur.clip] = true;
                }

                // 3. 삭제
                if (cur.desk >= 1 && !v[cur.desk-1][cur.clip]) {
                    q.offer(new Node(cur.desk-1, cur.clip));
                    v[cur.desk-1][cur.clip] = true;
                }

            }
            time++;
        }
    }
}