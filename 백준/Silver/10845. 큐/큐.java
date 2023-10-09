import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main
{
    public static Deque<Integer> dq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    dq.push(num);
                    break;

                case "pop":
                    if (!dq.isEmpty()){
                        sb.append(dq.pollLast()).append("\n");
                    }
                    else
                        sb.append(-1).append("\n");
                    break;

                case "size":
                    sb.append(dq.size()).append("\n");
                    break;

                case "empty":
                    if (dq.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else sb.append(0).append("\n");
                    break;

                case "front":
                    if (dq.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else sb.append(dq.getLast()).append("\n");
                    break;

                case "back":
                    if (dq.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else sb.append(dq.getFirst()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}