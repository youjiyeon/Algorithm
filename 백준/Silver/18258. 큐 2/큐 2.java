import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.push(num);
                    break;
                case "pop":
                    if (q.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(q.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(q.getLast()).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(q.getFirst()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
