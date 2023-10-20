import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        // 입력값을 queue에 저장 후 가장 처음부터 뺌
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int i = 1;
        while (!q.isEmpty()){
            int cur = q.peek();

            // 스택이 비어있거나 cur이 아닌 경우
            if (s.isEmpty() || cur>s.peek()){
                int j = 0;
                for (j = i; j <= cur; j++) {
                    s.add(j);
                    sb.append("+").append("\n");
                }
                i = j;
            }
            else if (cur<s.peek()){
                System.out.println("NO");
                System.exit(0);
            }
            else if (cur==s.peek()) {
                s.pop();
                q.poll();
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}