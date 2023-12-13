import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1)>Math.abs(o2)){
                return Math.abs(o1)-Math.abs(o2);
            }
            else if (Math.abs(o1)==Math.abs(o2)){
                return o1-o2;
            }
            else
                return Math.abs(o1)-Math.abs(o2);
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input!=0) {
                q.offer(input);
            }
            else {
                if (q.isEmpty()){
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(q.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}