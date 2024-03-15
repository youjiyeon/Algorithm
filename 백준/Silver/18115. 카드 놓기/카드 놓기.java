import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        // 1 2 3 4 5 ... N
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        for (int i = 1; i <= N; i++) {
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                // 맨위 카드 내려놓기
                case 1:
                    q.addFirst(i);
                    break;

                // 위에서 두번째 카드 내려놓기
                case 2:
                    int top = q.removeFirst();
                    q.addFirst(i);
                    q.addFirst(top);
                    break;

                // 맨아래 카드 내려놓기
                case 3:
                    q.addLast(i);
                    break;
            }
        }

        while (!q.isEmpty()) {
            sb.append(q.removeFirst()).append(" ");
        }
        System.out.println(sb);
    }
}