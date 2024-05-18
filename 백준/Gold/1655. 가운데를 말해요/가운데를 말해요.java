import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> bigQ = new PriorityQueue<>((o1, o2)->o2-o1);
        PriorityQueue<Integer> smallQ = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int in = Integer.parseInt(br.readLine());

            if (bigQ.size() == smallQ.size()) {
                bigQ.offer(in);

                if (!smallQ.isEmpty() && bigQ.peek() > smallQ.peek()) {
                    smallQ.add(bigQ.poll());
                    bigQ.add(smallQ.poll());
                }
            }
            else {
                smallQ.offer(in);

                if (bigQ.peek() > smallQ.peek()) {
                    smallQ.add(bigQ.poll());
                    bigQ.add(smallQ.poll());
                }
            }

            sb.append(bigQ.peek()).append("\n");
        }

        System.out.print(sb);
    }
}