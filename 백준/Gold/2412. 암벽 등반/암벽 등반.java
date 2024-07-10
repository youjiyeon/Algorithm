import java.io.*;
import java.util.*;

public class Main {
    static int n, T;
    static List<Integer>[] lists;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        lists = new List[T+1];
        for (int i = 0; i <= T; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[y].add(x);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.poll();

                if (y == T) {
                    return level;
                }

                for (int i = y-2; i <= y+2; i++) {
                    if (i<0 || i>T) continue;

                    for (int j = 0; j < lists[i].size(); j++) {
                        if (Math.abs(x - lists[i].get(j)) > 2) continue;

                        q.offer(new int[]{lists[i].get(j), i});
                        lists[i].remove(j);
                        j--;
                    }
                }
            }

            level++;
        }

        return -1;
    }
}