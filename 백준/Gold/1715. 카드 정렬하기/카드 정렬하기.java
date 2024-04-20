import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static long sum = 0;
    public static void main(String args[]) throws IOException {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            sum+=(a+b);
            pq.add(a+b);
        }

        System.out.println(sum);
    }
}