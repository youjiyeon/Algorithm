import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str){
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (q.size()==0){
                        sb.append(-1+"\n");
                    }
                    else {
                        sb.append(q.pollFirst()+"\n");
                    }
                    break;
                case "pop_back":
                    if (q.size()==0){
                        sb.append(-1+"\n");
                    }
                    else {
                        sb.append(q.pollLast()+"\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if (q.size()==0){
                        sb.append(1+"\n");
                    }
                    else {
                        sb.append(0+"\n");
                    }
                    break;
                case "front":
                    if (q.size()==0){
                        sb.append(-1+"\n");
                    }
                    else {
                        sb.append(q.getFirst()+"\n");
                    }
                    break;
                case "back":
                    if (q.size()==0){
                        sb.append(-1+"\n");
                    }
                    else {
                        sb.append(q.getLast()+"\n");
                    }
                    break;
            }

        }

        System.out.println(sb);
    }
}