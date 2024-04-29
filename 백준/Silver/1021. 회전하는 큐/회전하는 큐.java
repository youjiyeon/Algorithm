import java.io.*;
import java.util.*;

public class Main {
    public static int ans = 0, tmp;
    public static Deque<Integer> a = new ArrayDeque<>(), b = new ArrayDeque<>();
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            a.offer(i);
            b.offer(i);
        }

        while (!q.isEmpty()) {
            tmp = Integer.MAX_VALUE;
            recurA(q.peek(), 0);
            recurB(q.poll(), 0);

            ans += tmp;
        }

        System.out.println(ans);
    }

    public static void recurA(int target, int cnt) {
        if (a.peek() == target) {
            a.poll();
            tmp = Math.min(tmp, cnt);
            return;
        }

        int a1 = a.poll();
        a.offerLast(a1);
        recurA(target, cnt+1);
    }

    public static void recurB(int target, int cnt) {
        if (b.peek() == target) {
            b.poll();
            tmp = Math.min(tmp, cnt);
            return;
        }

        int b1 = b.pollLast();
        b.offerFirst(b1);
        recurB(target, cnt+1);
    }
}